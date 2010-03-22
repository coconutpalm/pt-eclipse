/*******************************************************************************
 * Copyright (c) 2004, 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package com.pt_connector.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.pt_connector.ui.wizard.messages"; //$NON-NLS-1$

    public static String PivotalTrackerRepositorySettingsPage_Project_ID_;

    public static String PivotalTrackerRepositorySettingsPage_Api_Token_;

    public static String PivotalTrackerRepositorySettingsPage_PIVOTAL_TRACKER_REPOSITORY_SETTINGS;

    public static String PivotalTrackerRepositorySettingsPage_URL_EXAMPLE;

	static {
		// load message values from bundle file
		reloadMessages();
	}

	public static void reloadMessages() {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

}
