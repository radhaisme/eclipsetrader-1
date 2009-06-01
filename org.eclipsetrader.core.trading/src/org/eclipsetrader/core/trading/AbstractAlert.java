/*
 * Copyright (c) 2004-2009 Marco Maccaferri and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marco Maccaferri - initial API and implementation
 */

package org.eclipsetrader.core.trading;

import java.util.HashMap;
import java.util.Map;

import org.eclipsetrader.core.feed.IQuote;
import org.eclipsetrader.core.feed.ITrade;

/**
 * Default implementation of the <code>IAlert</code> interface.
 * 
 * @since 1.0
 */
public abstract class AbstractAlert implements IAlert {

	public AbstractAlert() {
	}

	/* (non-Javadoc)
	 * @see org.eclipsetrader.core.trading.IAlert#getDescription()
	 */
	public String getDescription() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipsetrader.core.trading.IAlert#getId()
	 */
	public String getId() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipsetrader.core.trading.IAlert#getName()
	 */
	public String getName() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipsetrader.core.trading.IAlert#getParameters()
	 */
	public Map<String, Object> getParameters() {
		return new HashMap<String, Object>();
	}

	/* (non-Javadoc)
	 * @see org.eclipsetrader.core.trading.IAlert#isTriggered()
	 */
	public boolean isTriggered() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipsetrader.core.trading.IAlert#setInitialValues(org.eclipsetrader.core.feed.ITrade, org.eclipsetrader.core.feed.IQuote)
	 */
	public void setInitialValues(ITrade trade, IQuote quote) {
	}

	/* (non-Javadoc)
	 * @see org.eclipsetrader.core.trading.IAlert#setParameters(java.util.Map)
	 */
	public void setParameters(Map<String, Object> map) {
	}

	/* (non-Javadoc)
	 * @see org.eclipsetrader.core.trading.IAlert#setQuote(org.eclipsetrader.core.feed.IQuote)
	 */
	public void setQuote(IQuote quote) {
	}

	/* (non-Javadoc)
	 * @see org.eclipsetrader.core.trading.IAlert#setTrade(org.eclipsetrader.core.feed.ITrade)
	 */
	public void setTrade(ITrade trade) {
	}
}
