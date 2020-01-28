package de.diedavids.cuba.attachable.web.attachment;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.model.InstanceContainer;
import de.diedavids.cuba.attachable.entity.Attachment;
import org.codehaus.groovy.runtime.StringGroovyMethods;

import java.util.function.Consumer;

public class AttachmentNameExtractor implements Consumer<InstanceContainer.ItemPropertyChangeEvent<Attachment>> {

    @Override
    public void accept(InstanceContainer.ItemPropertyChangeEvent<Attachment> e) {
        if (fileChanged(e) && attachmentHasNoNameDefined(e.getItem())) {
            e.getItem().setName(getNameFromFile(e));
        }

    }

    private boolean attachmentHasNoNameDefined(Attachment attachment) {
        return attachment.getName() == null;
    }

    private String getNameFromFile(InstanceContainer.ItemPropertyChangeEvent<Attachment> e) {
        String filename =((FileDescriptor) e.getValue()).getName();

        int indexOfFileExtensionSeperator = filename.lastIndexOf(".");
        if (filenameHasExtension(indexOfFileExtensionSeperator)) {
            return filename.substring(0, indexOfFileExtensionSeperator);
        } else {
            return filename;
        }


    }

    private boolean filenameHasExtension(int indexOfFileExtensionSeperator) {
        return indexOfFileExtensionSeperator != -1;
    }

    private boolean fileChanged(InstanceContainer.ItemPropertyChangeEvent<Attachment> e) {
        return e.getProperty().equals("file") && e.getValue() != null;
    }

}
