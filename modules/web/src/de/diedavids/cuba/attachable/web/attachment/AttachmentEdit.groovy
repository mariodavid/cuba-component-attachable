package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.gui.components.AbstractEditor
import com.haulmont.cuba.gui.components.TextField
import com.haulmont.cuba.gui.data.Datasource
import de.diedavids.cuba.attachable.entity.Attachment

import javax.inject.Inject
import javax.inject.Named

class AttachmentEdit extends AbstractEditor<Attachment> {

    @Named("fieldGroup.name")
    TextField nameTextField

    @Inject
    Datasource<Attachment> attachmentDs

    @Override
    void init(Map<String, Object> params) {
        attachmentDs.addItemPropertyChangeListener(new CreateNameFromNameItemPropertyChangeListener(nameTextField: nameTextField))
    }
}