package com.pt_connector.ui;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.ITaskMapping;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.AbstractRepositoryConnectorUi;
import org.eclipse.mylyn.tasks.ui.wizards.ITaskRepositoryPage;
import org.eclipse.mylyn.tasks.ui.wizards.NewTaskWizard;

import com.pt_connector.core.PivotalTrackerCorePlugin;
import com.pt_connector.ui.wizard.PivotalTrackerRepsitorySettingsPage;

public class PivotalTrackerConnectorUi extends AbstractRepositoryConnectorUi {

    public PivotalTrackerConnectorUi() {
    }

    @Override
    public String getConnectorKind() {
        return PivotalTrackerCorePlugin.CONNECTOR_KIND;
    }

    @Override
    public IWizard getNewTaskWizard(TaskRepository taskRepository, ITaskMapping selection) {
        return new NewTaskWizard(taskRepository, selection);
    }

    @Override
    public IWizard getQueryWizard(TaskRepository taskRepository, IRepositoryQuery queryToEdit) {
        return null;
    }

    @Override
    public ITaskRepositoryPage getSettingsPage(TaskRepository taskRepository) {
        return new PivotalTrackerRepsitorySettingsPage(taskRepository);
    }

    @Override
    public boolean hasSearchPage() {
        return false;
    }

}
