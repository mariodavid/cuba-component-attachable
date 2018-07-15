package de.diedavids.cuba.attachable.service

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.entity.FileDescriptor
import com.haulmont.cuba.core.global.CommitContext
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.Metadata
import de.diedavids.cuba.attachable.entity.Attachment
import de.diedavids.cuba.entitysoftreference.SoftReferenceService
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(AttachmentService.NAME)
class AttachmentServiceBean implements AttachmentService {

    private static final String ATTACHABLE_COLUMN_NAME = 'attachable'

    @Inject
    SoftReferenceService softReferenceService

    @Inject
    Metadata metadata

    @Inject
    DataManager dataManager

    @Override
    int countAttachments(Entity entity) {
        softReferenceService.countEntitiesForSoftReference(Attachment, entity, ATTACHABLE_COLUMN_NAME)
    }

    @Override
    Collection<Attachment> getAttachments(Entity entity) {
        softReferenceService.loadEntitiesForSoftReference(
                Attachment,
                entity,
                ATTACHABLE_COLUMN_NAME,
                'attachment-view'
        ) as Collection<Attachment>
    }

    @Override
    void createAttachments(Entity entity, Collection<FileDescriptor> files) {

        CommitContext commitContext = new CommitContext()

        files.each { file ->
            def attachmentToCreate = metadata.create(Attachment)
            attachmentToCreate.file = file
            attachmentToCreate.name = file.name
            attachmentToCreate.attachable = entity

            commitContext.addInstanceToCommit(attachmentToCreate)
        }

        dataManager.commit(commitContext)
    }
}