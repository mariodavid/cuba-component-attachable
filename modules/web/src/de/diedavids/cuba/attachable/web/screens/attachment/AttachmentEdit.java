package de.diedavids.cuba.attachable.web.screens.attachment;

import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.attachable.entity.Attachment;
import de.diedavids.cuba.attachable.web.attachment.AttachmentNameExtractor;

import javax.inject.Inject;

@UiController("ddca$Attachment.edit")
@UiDescriptor("attachment-edit.xml")
@EditedEntityContainer("attachmentDc")
@LoadDataBeforeShow
public class AttachmentEdit extends StandardEditor<Attachment> {

    @Inject
    protected InstanceContainer<Attachment> attachmentDc;

    @Subscribe
    protected void onInit(InitEvent event) {
        attachmentDc.addItemPropertyChangeListener(new AttachmentNameExtractor());
    }
    
    
    
}