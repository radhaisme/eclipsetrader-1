/*
 * Copyright (c) 2004-2006 Marco Maccaferri and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marco Maccaferri - initial API and implementation
 */

package net.sourceforge.eclipsetrader.trading.wizards;

import net.sourceforge.eclipsetrader.core.CorePlugin;
import net.sourceforge.eclipsetrader.core.db.Account;
import net.sourceforge.eclipsetrader.core.db.AccountGroup;
import net.sourceforge.eclipsetrader.trading.wizards.accounts.CommissionsPage;
import net.sourceforge.eclipsetrader.trading.wizards.accounts.GeneralPage;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

public class AccountWizard extends Wizard
{
    private Account account;
    private GeneralPage generalPage = new GeneralPage();
    private CommissionsPage commissionsPage = new CommissionsPage();

    public AccountWizard()
    {
    }

    public Account open()
    {
        WizardDialog dlg = create();
        dlg.open();
        return account;
    }

    public Account open(AccountGroup group)
    {
        WizardDialog dlg = create();
        generalPage.setGroup(group);
        dlg.open();
        return account;
    }
    
    public WizardDialog create()
    {
        setWindowTitle("New Account Wizard");
        
        addPage(new CommonWizardPage(generalPage));
        addPage(new CommonWizardPage(commissionsPage));

        WizardDialog dlg = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), this);
        dlg.create();
        
        return dlg;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    public boolean performFinish()
    {
        account = new Account();
        
        account.setDescription(generalPage.getText());
        account.setInitialBalance(generalPage.getBalance());
        AccountGroup group = generalPage.getGroup();
        if (group != null)
        {
            account.setGroup(group);
            group.getAccounts().add(account);
            CorePlugin.getRepository().save(group);
        }
        
        account.setVariableCommissions(commissionsPage.getVariableCommission());
        account.setFixedCommissions(commissionsPage.getFixedCommission());
        account.setMinimumCommission(commissionsPage.getMinimumCommission());
        account.setMaximumCommission(commissionsPage.getMaximumCommission());

        CorePlugin.getRepository().save(account);
        
        return true;
    }
}
