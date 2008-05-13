/*
 * Copyright (c) 2004-2008 Marco Maccaferri and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marco Maccaferri - initial API and implementation
 */

package org.eclipsetrader.ui.internal.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipsetrader.core.internal.views.WatchList;
import org.eclipsetrader.core.repositories.IRepository;
import org.eclipsetrader.core.views.IWatchList;
import org.eclipsetrader.ui.internal.UIActivator;

public class WatchListWizard extends Wizard implements INewWizard {
	private Image image;
	private NamePage namePage;
	private ColumnsPage columnsPage;

	private IWatchList resource;
	private IRepository repository;

	public WatchListWizard() {
		ImageDescriptor descriptor = ImageDescriptor.createFromURL(UIActivator.getDefault().getBundle().getResource("icons/wizban/newfile_wiz.gif"));
		image = descriptor.createImage();
	}

	/* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#dispose()
     */
    @Override
    public void dispose() {
    	if (image != null)
    		image.dispose();
	    super.dispose();
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#getWindowTitle()
     */
    @Override
    public String getWindowTitle() {
	    return "New Watch List";
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#getDefaultPageImage()
     */
    @Override
    public Image getDefaultPageImage() {
	    return image;
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    @Override
    public void addPages() {
	    addPage(namePage = new NamePage());
	    addPage(columnsPage = new ColumnsPage());
    }

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		repository = namePage.getRepository();
		resource = new WatchList(namePage.getResourceName(), columnsPage.getColumns());
		return true;
	}

	public IWatchList getResource() {
    	return resource;
    }

	public IRepository getRepository() {
    	return repository;
    }
}