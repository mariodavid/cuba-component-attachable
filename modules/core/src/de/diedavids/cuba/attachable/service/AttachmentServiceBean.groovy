package de.diedavids.cuba.attachable.service

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.Metadata
import de.diedavids.cuba.attachable.entity.Attachment
import de.diedavids.cuba.entitysoftreference.SoftReferenceService
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(AttachmentService.NAME)
public class AttachmentServiceBean implements AttachmentService {


    @Inject
    SoftReferenceService softReferenceService

    @Inject
    Metadata metadata

    @Override
    int countAttachments(Entity entity) {

        def attachmentMetaClass = metadata.getClass(Attachment)

        def result = softReferenceService.getEntitiesForSoftReference(attachmentMetaClass, entity, "attachable")

        result.size()
    }
}