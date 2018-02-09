package de.diedavids.cuba.attachable.entity;

import javax.persistence.*;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.*;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.entity.annotation.SystemLevel;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.haulmont.chile.core.annotations.NamePattern;
import de.diedavids.cuba.entitysoftreference.EntitySoftReferenceConverter;
import de.diedavids.cuba.entitysoftreference.EntitySoftReferenceDatatype;

@NamePattern("%s|name")
@Table(name = "DDCA_ATTACHEMENT")
@Entity(name = "ddca$Attachment")
public class Attachment extends StandardEntity {
    private static final long serialVersionUID = -5689061909136000090L;


    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;


    @NotNull
    @SystemLevel
    @Convert(converter = EntitySoftReferenceConverter.class)
    @MetaProperty(datatype = "EntitySoftReference", mandatory = true)
    @Column(name = "ATTACHABLE", nullable = false)
    protected com.haulmont.cuba.core.entity.Entity attachable;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID")
    protected FileDescriptor file;

    public com.haulmont.cuba.core.entity.Entity getAttachable() {
        return attachable;
    }

    public void setAttachable(com.haulmont.cuba.core.entity.Entity attachable) {
        this.attachable = attachable;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFile(FileDescriptor file) {
        this.file = file;
    }

    public FileDescriptor getFile() {
        return file;
    }


}