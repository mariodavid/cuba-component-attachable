package de.diedavids.cuba.attachable.service;

import com.haulmont.cuba.core.entity.Entity;
import de.diedavids.cuba.attachable.entity.Attachment;

import java.util.Collection;


public interface AttachmentService {
    String NAME = "ddca_AttachmentService";

    int countAttachments(Entity entity);
    Collection<Attachment> getAttachments(Entity entity);
}