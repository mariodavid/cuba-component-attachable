package de.diedavids.cuba.attachable.web

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.Messages
import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.components.Action
import com.haulmont.cuba.gui.components.Frame
import com.haulmont.cuba.gui.components.Window
import de.diedavids.cuba.attachable.config.AttachableConfiguration
import de.diedavids.cuba.attachable.service.AttachmentService
import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

import javax.inject.Inject

@Component(WithAttachmentsSupportExecution.NAME)
@CompileStatic
class WithAttachmentsSupportExecutionBean implements WithAttachmentsSupportExecution {

    private static final String ATTACHMENTS_ICON = 'font-icon:PAPERCLIP'
    private static final String ACTION_MSG_KEY = 'actions.Attachments'
    private static final String ACTION_COUNT_MSG_KEY = 'actions.Attachments.count'

    @Inject
    AttachmentService attachmentService

    @Inject
    AttachableConfiguration attachableConfiguration

    @Inject
    Messages messages


    @Override
    void setIcon(Action action) {
        action.icon = ATTACHMENTS_ICON
    }

    @Override
    void updateCaption(Action action, Entity entity) {
        if (entity && attachableConfiguration.updateAttachmentCounterOnSelect) {
            int attachmentCount = attachmentService.countAttachments(entity)
            action.caption = messages.formatMainMessage(ACTION_COUNT_MSG_KEY, attachmentCount)
        } else {
            action.caption = messages.getMainMessage(ACTION_MSG_KEY)
        }
    }

    @Override
    Window openAttachmentBrowse(Frame frame, Action action, Entity entity, WindowManager.OpenType openType) {
        Window browse = frame.openWindow(
                'ddca$Attachment.browse',
                openType ?: WindowManager.OpenType.DIALOG,
                [entity: entity] as Map<String, Object>)

        browse.addCloseListener(new Window.CloseListener() {
            @Override
            void windowClosed(String actionId) {
                updateCaption(action, entity)
            }
        })

        browse
    }
}
