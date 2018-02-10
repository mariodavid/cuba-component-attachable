package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.gui.components.TextField
import com.haulmont.cuba.gui.data.Datasource
import de.diedavids.cuba.attachable.entity.Attachment

class CreateNameFromNameItemPropertyChangeListener implements Datasource.ItemPropertyChangeListener<Attachment> {

    TextField nameTextField

    @Override
    void itemPropertyChanged(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        if (fileChanged(e)) {
            nameTextField.value = getNameFromFile(e)
        }
    }

    private void getNameFromFile(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        e.value.name
    }

    private boolean fileChanged(Datasource.ItemPropertyChangeEvent<Attachment> e) {
        e.property == 'file' && e.value
    }
}