package com.pt_connector.ui.editor;

import org.eclipse.mylyn.tasks.ui.ITasksUiConstants;
import org.eclipse.mylyn.tasks.ui.TasksUiUtil;
import org.eclipse.mylyn.tasks.ui.editors.AbstractTaskEditorPageFactory;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditor;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditorInput;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.forms.editor.IFormPage;

import com.pt_connector.core.PivotalTrackerCorePlugin;

public class PivotalTrackerTaskEditorPageFactory extends AbstractTaskEditorPageFactory {

    public PivotalTrackerTaskEditorPageFactory() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean canCreatePageFor(TaskEditorInput input) {
        if (input.getTask().getConnectorKind().equals(PivotalTrackerCorePlugin.CONNECTOR_KIND)) {
            return true;
        } else if (TasksUiUtil.isOutgoingNewTask(input.getTask(), PivotalTrackerCorePlugin.CONNECTOR_KIND)) {
            return true;
        }
        return false;
    }

    @Override
    public IFormPage createPage(TaskEditor parentEditor) {
        return new PivotalTrackerTaskEditorPage(parentEditor, PivotalTrackerCorePlugin.CONNECTOR_KIND);
    }

    @Override
    public String[] getConflictingIds(TaskEditorInput input) {
        return new String[] { ITasksUiConstants.ID_PAGE_PLANNING };
    }


    @Override
    public String getPageText() {
        return "Trac"; //$NON-NLS-1$
    }

    @Override
    public int getPriority() {
        return PRIORITY_TASK;
    }

    @Override
    public Image getPageImage() {
        // TODO Auto-generated method stub
        return null;
    }

}
