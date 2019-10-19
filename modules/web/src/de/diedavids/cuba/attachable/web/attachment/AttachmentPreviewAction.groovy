package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.core.global.Messages
import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.Frame
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction
import de.diedavids.cuba.attachable.entity.Attachment

class AttachmentPreviewAction extends ItemTrackingAction {

    public static final String ACTION_ID = 'preview'

    Frame frame

    Messages messages = AppBeans.get(Messages.NAME)


    AttachmentPreviewAction() {
        super(ACTION_ID)

        this.caption = messages.getMessage(getClass(), 'actions.Preview')
        this.icon = 'font-icon:SEARCH'
    }

    @Override
    void actionPerform(Component component) {
        Attachment attachment = target.singleSelected as Attachment
        frame.openEditor('ddca$Attachment.preview', attachment, WindowManager.OpenType.DIALOG)
    }
}