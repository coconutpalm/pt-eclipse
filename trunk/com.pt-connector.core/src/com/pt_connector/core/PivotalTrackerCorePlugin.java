package com.pt_connector.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class PivotalTrackerCorePlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.pt_connector.core";

	public static final String CONNECTOR_KIND = "Pivotal Tracker";

	// The shared instance
	private static PivotalTrackerCorePlugin plugin;
	
	/**
	 * The constructor
	 */
	public PivotalTrackerCorePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static PivotalTrackerCorePlugin getDefault() {
		return plugin;
	}

}
