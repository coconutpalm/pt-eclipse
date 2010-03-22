package com.pt_connector.ui.wizard;

import org.eclipse.mylyn.tasks.core.RepositoryTemplate;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.swt.widgets.Composite;

import com.pt_connector.core.PivotalTrackerCorePlugin;

public class PivotalTrackerRepsitorySettingsPage extends
		AbstractRepositorySettingsPage {

	public PivotalTrackerRepsitorySettingsPage(TaskRepository taskRepository) {
		super("Pivotal Tracker Repository Settings", "Settings for Pivotal Tracker Repository", taskRepository);
		setNeedsAnonymousLogin(false);
		setNeedsEncoding(false);
		setNeedsTimeZone(false);
		setNeedsAdvanced(false);
		setNeedsHttpAuth(false);
	}
		
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		addRepositoryTemplatesToServerUrlCombo();
	}
	
	@Override
	protected void repositoryTemplateSelected(RepositoryTemplate template) {
		repositoryLabelEditor.setStringValue(template.label);
		setUrl(template.repositoryUrl);
		getContainer().updateButtons();
	}

	@Override
	protected void createAdditionalControls(Composite parent) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getConnectorKind() {
		return PivotalTrackerCorePlugin.CONNECTOR_KIND;
	}

	@Override
	protected Validator getValidator(TaskRepository repository) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValidUrl(String url) {
		return url != null && url.trim().length() > 0;
	}

}
