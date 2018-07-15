package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.gui.data.Datasource
import de.diedavids.cuba.attachable.entity.Attachment

class AttachmentNameExtractor implements Datasource.ItemPropertyChangeListener<Attachment> {

    @Override
    void itemPropertyChanged(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        if (fileChanged(e) && attachmentHasNoNameDefined(e)) {
                e.item.name = getNameFromFile(e)
        }
    }

    protected boolean attachmentHasNoNameDefined(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        !e.item.name
    }

    private String getNameFromFile(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        String filename = e.value.name

        def indexOfFileExtensionSeperator = filename.lastIndexOf('.')
        if (filenameHasExtension(indexOfFileExtensionSeperator)) {
            filename.take(indexOfFileExtensionSeperator)
        }
        else {
            filename
        }

    }

    protected boolean filenameHasExtension(int indexOfFileExtensionSeperator) {
        indexOfFileExtensionSeperator != -1
    }

    private boolean fileChanged(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        e.property == 'file' && e.value
    }
}