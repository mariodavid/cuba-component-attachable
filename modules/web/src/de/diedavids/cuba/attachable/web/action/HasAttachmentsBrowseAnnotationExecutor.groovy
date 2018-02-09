package de.diedavids.cuba.attachable.web.action

import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.ButtonsPanel
import com.haulmont.cuba.gui.components.ListComponent
import com.haulmont.cuba.gui.components.Window
import de.balvi.cuba.declarativecontrollers.web.annotationexecutor.browse.BrowseAnnotationExecutor
import de.balvi.cuba.declarativecontrollers.web.helper.ButtonsPanelHelper
import de.diedavids.cuba.attachable.web.HasAttachments
import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

import javax.inject.Inject
import java.lang.annotation.Annotation

@CompileStatic
@Component('ddca$HasAttachmentsBrowseAnnotationExecutor')
class HasAttachmentsBrowseAnnotationExecutor implements BrowseAnnotationExecutor<HasAttachments> {

    static final List<String> PRE_BUTTONS = [
            'createBtn',
            'editBtn',
            'removeBtn',
            'refreshBtn',
            'excelBtn',
            'reportBtn',
    ].asImmutable()


    @Inject
    ButtonsPanelHelper buttonsPanelHelper

    @SuppressWarnings('Instanceof')
    boolean supports(Annotation annotation) {
        annotation instanceof HasAttachments
    }

    @Override
    void init(HasAttachments annotation, Window.Lookup browse, Map<String, Object> params) {
        ListComponent listComponent = browse.getComponent(annotation.listComponent()) as ListComponent
        def action = new TableHasAttachmentsAction(listComponent)
        listComponent.addAction(action)
        if (annotation.buttonsPanel()) {
            ButtonsPanel buttonsPanel = browse.getComponent(annotation.buttonsPanel()) as ButtonsPanel
            Button attachmentsBtn = buttonsPanelHelper.createButton(annotation.buttonId(), buttonsPanel, PRE_BUTTONS)
            attachmentsBtn.action = action
        }
    }

    @Override
    void ready(HasAttachments annotation, Window.Lookup browse, Map<String, Object> params) {

    }
}