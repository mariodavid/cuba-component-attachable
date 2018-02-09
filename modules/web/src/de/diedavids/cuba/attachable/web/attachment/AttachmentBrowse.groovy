package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.gui.WindowParam
import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.actions.CreateAction

import javax.inject.Named

class AttachmentBrowse extends AbstractLookup {

    @WindowParam
    Entity entity

    @Named('attachmentsTable.create')
    CreateAction createAction

    @Override
    void init(Map<String, Object> params) {
        createAction.setInitialValues(['attachable': entity])
    }
}