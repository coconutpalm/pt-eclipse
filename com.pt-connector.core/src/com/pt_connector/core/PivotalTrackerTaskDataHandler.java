/**
 * 
 */
package com.pt_connector.core;

import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.mylyn.tasks.core.ITaskMapping;
import org.eclipse.mylyn.tasks.core.RepositoryResponse;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.data.AbstractTaskDataHandler;
import org.eclipse.mylyn.tasks.core.data.TaskAttribute;
import org.eclipse.mylyn.tasks.core.data.TaskAttributeMapper;
import org.eclipse.mylyn.tasks.core.data.TaskData;

/**
 * @author anders
 * 
 */
public class PivotalTrackerTaskDataHandler extends AbstractTaskDataHandler {

    private final PivotalTrackerRepositoryConnector connector;

    public PivotalTrackerTaskDataHandler(PivotalTrackerRepositoryConnector connector) {
        this.connector = connector;
    }

    /*
     * (non-Javadoc)
     * 
     * @seeorg.eclipse.mylyn.tasks.core.data.AbstractTaskDataHandler#getAttributeMapper(org.eclipse.mylyn.tasks.core.
     * TaskRepository)
     */
    @Override
    public TaskAttributeMapper getAttributeMapper(TaskRepository taskRepository) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @seeorg.eclipse.mylyn.tasks.core.data.AbstractTaskDataHandler#initializeTaskData(org.eclipse.mylyn.tasks.core.
     * TaskRepository, org.eclipse.mylyn.tasks.core.data.TaskData, org.eclipse.mylyn.tasks.core.ITaskMapping,
     * org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public boolean initializeTaskData(TaskRepository repository, TaskData data, ITaskMapping initializationData,
            IProgressMonitor monitor) throws CoreException {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.mylyn.tasks.core.data.AbstractTaskDataHandler#postTaskData(org.eclipse.mylyn.tasks.core.TaskRepository
     * , org.eclipse.mylyn.tasks.core.data.TaskData, java.util.Set, org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public RepositoryResponse postTaskData(TaskRepository repository, TaskData taskData,
            Set<TaskAttribute> oldAttributes, IProgressMonitor monitor) throws CoreException {
        // TODO Auto-generated method stub
        return null;
    }

}
