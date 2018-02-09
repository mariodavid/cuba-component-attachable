package de.diedavids.cuba.attachable.service;

import com.haulmont.cuba.core.entity.Entity;


public interface AttachmentService {
    String NAME = "ddca_AttachmentService";

    int countAttachments(Entity entity);
}