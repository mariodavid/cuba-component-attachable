package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.WindowParam
import com.haulmont.cuba.gui.app.core.file.MultiUploader
import com.haulmont.cuba.gui.components.Table
import com.haulmont.cuba.gui.components.Window
import com.haulmont.cuba.gui.components.actions.CreateAction
import com.haulmont.cuba.gui.data.CollectionDatasource
import de.balvi.cuba.declarativecontrollers.web.browse.AnnotatableAbstractLookup
import de.diedavids.cuba.attachable.entity.Attachment
import de.diedavids.cuba.attachable.service.AttachmentService
import de.diedavids.cuba.taggable.web.WithTags

import javax.inject.Inject
import javax.inject.Named

@WithTags(listComponent = 'attachmentsTable', showTagsInList = true, showTagsAsLink = true, tagLinkOpenType = 'NEW_TAB')
class AttachmentBrowse extends AnnotatableAbstractLookup {

    @WindowParam
    Entity entity

    @Named('attachmentsTable.create')
    CreateAction createAction

    @Inject
    Table attachmentsTable

    @Inject
    CollectionDatasource<Attachment, UUID> attachmentsDs

    @Inject
    AttachmentService attachmentService

    @Override
    void init(Map<String, Object> params) {
        super.init(params)
        initCreateAction()
        initDownloadAction()
        initAttachmentDs()
        initCaption()
    }

    void initCaption() {
        setCaption(formatMessage('browseCaption', entity.instanceName))
    }

    void initAttachmentDs() {
        attachmentsDs.refresh([entity: entity])
    }

    private initCreateAction() {
        createAction.setInitialValues(['attachable': entity])
    }

    private initDownloadAction() {
        attachmentsTable.addAction(new AttachmentDownloadAction())
        attachmentsTable.addAction(new AttachmentPreviewAction(frame: frame))
    }

    @SuppressWarnings('UnusedMethodParameter')
    void previewFile(Entity item, String columnId) {
        Attachment attachment = item as Attachment
        frame.openEditor('ddca$Attachment.preview', attachment, WindowManager.OpenType.DIALOG)
    }

    void multiupload() {
        MultiUploader multiUploadDialog = openWindow('multiuploadDialog', WindowManager.OpenType.DIALOG) as MultiUploader
        multiUploadDialog.addCloseWithCommitListener(new Window.CloseWithCommitListener() {
            @Override
            void windowClosedWithCommitAction() {
                def filesToCreateAttachmentsFor = multiUploadDialog.files
                attachmentService.storeAttachmentsFor(entity, filesToCreateAttachmentsFor)
                attachmentsDs.refresh()
            }
        })
    }
}