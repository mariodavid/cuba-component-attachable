package de.diedavids.cuba.attachable.web.annotationexecutor

import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.Window
import de.balvi.cuba.declarativecontrollers.web.annotationexecutor.editor.EditorAnnotationExecutor
import de.balvi.cuba.declarativecontrollers.web.helper.ButtonsPanelHelper
import de.diedavids.cuba.attachable.web.HasAttachments
import de.diedavids.cuba.attachable.web.annotationexecutor.action.EditorHasAttachmentsAction
import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

import javax.inject.Inject
import java.lang.annotation.Annotation

@CompileStatic
@Component('ddca$HasAttachmentsEditorAnnotationExecutor')
class HasAttachmentsEditorAnnotationExecutor implements EditorAnnotationExecutor<HasAttachments> {


    @Inject
    ButtonsPanelHelper buttonsPanelHelper


    @SuppressWarnings('Instanceof')
    boolean supports(Annotation annotation) {
        annotation instanceof HasAttachments
    }

    @Override
    void init(HasAttachments annotation, Window.Editor editor, Map<String, Object> params) {
        Button button = buttonsPanelHelper.getOrCreateButton(editor, annotation.buttonId(), annotation.buttonsPanel())
        button.action = new EditorHasAttachmentsAction(editor)
    }

    @Override
    void postInit(HasAttachments annotation, Window.Editor editor) {
        Button attachmentsBtn = editor.getComponent(annotation.buttonId()) as Button
        EditorHasAttachmentsAction action = (EditorHasAttachmentsAction) attachmentsBtn.action
        action.updateCaption()
    }
}