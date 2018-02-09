package de.diedavids.cuba.attachable.service

import com.haulmont.chile.core.model.MetaClass
import com.haulmont.cuba.core.entity.Entity
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

    @Override
    int countAttachments(Entity entity) {
        softReferenceService.getEntitiesForSoftReference(
                findMetaClass(Attachment),
                entity,
                ATTACHABLE_COLUMN_NAME
        ).size()
    }

    private MetaClass findMetaClass(Class aClass) {
        metadata.getClass(aClass)
    }
}