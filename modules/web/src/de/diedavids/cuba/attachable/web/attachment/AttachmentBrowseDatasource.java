package de.diedavids.cuba.attachable.web.attachment;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.impl.CustomCollectionDatasource;
import de.diedavids.cuba.attachable.entity.Attachment;
import de.diedavids.cuba.attachable.service.AttachmentService;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class AttachmentBrowseDatasource extends CustomCollectionDatasource<Attachment, UUID> {

    private AttachmentService attachmentService = AppBeans.get(AttachmentService.class);

    @Override
    protected Collection<Attachment> getEntities(Map<String, Object> params) {
        return attachmentService.getAttachments((Entity) params.get("entity"));
    }
}
