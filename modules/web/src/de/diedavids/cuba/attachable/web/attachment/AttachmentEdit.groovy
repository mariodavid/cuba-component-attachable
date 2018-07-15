package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.gui.components.AbstractEditor
import com.haulmont.cuba.gui.data.Datasource
import de.diedavids.cuba.attachable.entity.Attachment

import javax.inject.Inject

class AttachmentEdit extends AbstractEditor<Attachment> {

    @Inject
    Datasource<Attachment> attachmentDs

    @Override
    void init(Map<String, Object> params) {
        initNameExtractor()
    }

    private initNameExtractor() {
        attachmentDs.addItemPropertyChangeListener(new AttachmentNameExtractor())
    }
}