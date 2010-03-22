/**
 * 
 */
package com.pt_connector.ui.editor;

import org.eclipse.mylyn.tasks.ui.editors.AbstractTaskEditorPage;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditor;

/**
 * @author anders
 * 
 */
public class PivotalTrackerTaskEditorPage extends AbstractTaskEditorPage {

	public PivotalTrackerTaskEditorPage(TaskEditor editor, String connectorKind) {
		super(editor, connectorKind);
		setNeedsPrivateSection(true);
		setNeedsSubmitButton(true);
	}
	
}
