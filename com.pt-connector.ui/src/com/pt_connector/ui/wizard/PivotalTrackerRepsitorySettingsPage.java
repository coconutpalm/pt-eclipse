package com.pt_connector.ui.wizard;

//import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.mylyn.tasks.core.RepositoryTemplate;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.swt.widgets.Composite;

import com.pt_connector.core.PivotalTrackerCorePlugin;
import com.pt_connector.ui.PivotalTrackerUIPlugin;

public class PivotalTrackerRepsitorySettingsPage extends AbstractRepositorySettingsPage {

    protected static final String LABEL_USER = Messages.PivotalTrackerRepositorySettingsPage_Project_ID_;

    protected static String LABEL_PASSWORD = Messages.PivotalTrackerRepositorySettingsPage_Api_Token_;

    private static final String TITLE = Messages.PivotalTrackerRepositorySettingsPage_PIVOTAL_TRACKER_REPOSITORY_SETTINGS;

    private static final String DESCRIPTION = Messages.PivotalTrackerRepositorySettingsPage_URL_EXAMPLE;

    String serverUrl = "http://www.pivotaltracker.com/services/v3/";

    public PivotalTrackerRepsitorySettingsPage(TaskRepository taskRepository) {
        super(TITLE, DESCRIPTION, taskRepository);
        setNeedsAnonymousLogin(false);
        setNeedsEncoding(false);
        setNeedsTimeZone(false);
        setNeedsAdvanced(false);
        setNeedsHttpAuth(false);
    }
    
    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        savePasswordButton.setText("Save token");
         
        addRepositoryTemplatesToServerUrlCombo();
        
        if (repository == null) {
            setUrl(serverUrl);
        }
    }
    
    @Override
    protected void repositoryTemplateSelected(RepositoryTemplate template) {
        repositoryLabelEditor.setStringValue(template.label);
        setUrl(template.repositoryUrl);
        getContainer().updateButtons();
    }

    @Override
    public String getConnectorKind() {
        return PivotalTrackerCorePlugin.CONNECTOR_KIND;
    }

    @Override
    protected Validator getValidator(TaskRepository repository) {
        return new PivotalTrackerRepositoryValidator(repository);
    }

    @Override
    protected boolean isValidUrl(String url) {
        return url != null && url.trim().length() > 0 && url.startsWith("http");
    }

    @Override
    protected void applyValidatorResult(Validator validator) {
        PivotalTrackerRepositoryValidator pivotalTrackerRepositoryValidator = (PivotalTrackerRepositoryValidator) validator;

        // TODO Do something useful here.
        
        super.applyValidatorResult(validator);
    }

    public class PivotalTrackerRepositoryValidator extends Validator {

        final TaskRepository repository;

        public PivotalTrackerRepositoryValidator(TaskRepository repository) {
            this.repository = repository;
        }

        @Override
        public void run(IProgressMonitor monitor) throws CoreException {
            try {
                new URL(repository.getRepositoryUrl());
            } catch (MalformedURLException ex) {
                throw new CoreException(new Status(IStatus.ERROR, PivotalTrackerUIPlugin.PLUGIN_ID, IStatus.OK, INVALID_REPOSITORY_URL, null));
            }
            // TODO More validation here. Project id and API token should be integers only etc.
        }
    }
    
    @Override
    protected void createAdditionalControls(Composite parent) {
        // TODO Auto-generated method stub
        
    }
}