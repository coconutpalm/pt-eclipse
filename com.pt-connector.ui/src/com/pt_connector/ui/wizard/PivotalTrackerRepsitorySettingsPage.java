package com.pt_connector.ui.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.mylyn.tasks.core.RepositoryTemplate;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.swt.widgets.Composite;

import com.pt_connector.core.PivotalTrackerCorePlugin;
import com.pt_connector.core.util.ReflectionUtil;

public class PivotalTrackerRepsitorySettingsPage extends AbstractRepositorySettingsPage {

    String serverUrl = "http://www.pivotaltracker.com/services/v3/";

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
        if (repository == null) {
            setUrl(serverUrl);
        }
        
        // FIXME Not a very nice way of changing the label values.
        try {
            ReflectionUtil.setStaticFieldValue(AbstractRepositorySettingsPage.class, "LABEL_USER", "Project Id:");
            ReflectionUtil.setStaticFieldValue(AbstractRepositorySettingsPage.class, "LABEL_PASSWORD", "API Token:");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        
        savePasswordButton.setText("Save token");
    }
    
    @Override
    protected void repositoryTemplateSelected(RepositoryTemplate template) {
        repositoryLabelEditor.setStringValue(template.label);
        setUrl(template.repositoryUrl);
        setUserId("user");
        setPassword("pass");
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
