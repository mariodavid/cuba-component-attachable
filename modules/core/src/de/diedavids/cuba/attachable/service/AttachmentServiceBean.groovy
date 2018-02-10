package de.diedavids.cuba.attachable.service

import com.haulmont.cuba.core.entity.Entity
import de.diedavids.cuba.attachable.entity.Attachment
import de.diedavids.cuba.entitysoftreference.SoftReferenceService
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(AttachmentService.NAME)
class AttachmentServiceBean implements AttachmentService {

    private static final String ATTACHABLE_COLUMN_NAME = 'attachable'

    @Inject
    SoftReferenceService softReferenceService

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

}