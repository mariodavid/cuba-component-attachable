package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.gui.AppConfig
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction
import de.diedavids.cuba.attachable.entity.Attachment

class AttachmentDownloadAction extends ItemTrackingAction {

    public static final String ACTION_ID = 'download'

    AttachmentDownloadAction() {
        super(ACTION_ID)

        this.caption = messages.getMessage(getClass(), 'actions.Download')
        this.icon = 'icons/download.png'
    }

    @Override
    void actionPerform(Component component) {
        Attachment attachment = target.singleSelected
        if (attachment && attachment.file) {
            AppConfig.createExportDisplay(target.frame).show(attachment.file)
        }
    }
}
