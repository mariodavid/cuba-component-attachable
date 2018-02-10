package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.gui.components.TextField
import com.haulmont.cuba.gui.data.Datasource
import de.diedavids.cuba.attachable.entity.Attachment

class AttachmentNameExtractor implements Datasource.ItemPropertyChangeListener<Attachment> {

    TextField destination

    @Override
    void itemPropertyChanged(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        if (fileChanged(e)) {
            destination.value = getNameFromFile(e)
        }
    }

    private void getNameFromFile(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        e.value.name
    }

    private boolean fileChanged(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        e.property == 'file' && e.value
    }
}