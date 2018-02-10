package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.WindowParam
import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.Table
import com.haulmont.cuba.gui.components.actions.CreateAction
import de.diedavids.cuba.attachable.entity.Attachment

import javax.inject.Inject
import javax.inject.Named

class AttachmentBrowse extends AbstractLookup {

    @WindowParam
    Entity entity

    @Named('attachmentsTable.create')
    CreateAction createAction

    @Inject
    Table attachmentsTable

    @Override
    void init(Map<String, Object> params) {
        initCreateAction()
        initDownloadAction()
    }

    private initCreateAction() {
        createAction.setInitialValues(['attachable': entity])
    }

    private initDownloadAction() {
        attachmentsTable.addAction(new AttachmentDownloadAction())
        attachmentsTable.addAction(new AttachmentPreviewAction(frame: frame))
    }

    public void previewFile(Entity item, String columnId) {

        Attachment attachment = item as Attachment
        frame.openEditor('ddca$Attachment.preview', attachment, WindowManager.OpenType.DIALOG)
    }
}