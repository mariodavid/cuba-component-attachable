package de.diedavids.cuba.attachable.web.annotationexecutor

import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.Window
import de.balvi.cuba.declarativecontrollers.web.annotationexecutor.editor.EditorAnnotationExecutor
import de.balvi.cuba.declarativecontrollers.web.helper.ButtonsPanelHelper
import de.diedavids.cuba.attachable.web.WithAttachments
import de.diedavids.cuba.attachable.web.annotationexecutor.action.EditorWithAttachmentsAction
import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

import javax.inject.Inject
import java.lang.annotation.Annotation

@CompileStatic
@Component('ddca$HasAttachmentsEditorAnnotationExecutor')
class WithAttachmentsEditorAnnotationExecutor implements EditorAnnotationExecutor<WithAttachments> {


    @Inject
    ButtonsPanelHelper buttonsPanelHelper


    @SuppressWarnings('Instanceof')
    boolean supports(Annotation annotation) {
        annotation instanceof WithAttachments
    }

    @Override
    void init(WithAttachments annotation, Window.Editor editor, Map<String, Object> params) {
        Button button = buttonsPanelHelper.getOrCreateButton(editor, annotation.buttonId(), annotation.buttonsPanel())
        button.action = new EditorWithAttachmentsAction(editor)
    }

    @Override
    void postInit(WithAttachments annotation, Window.Editor editor) {
        Button attachmentsBtn = editor.getComponent(annotation.buttonId()) as Button
        EditorWithAttachmentsAction action = (EditorWithAttachmentsAction) attachmentsBtn.action
        action.updateCaption()
    }
}