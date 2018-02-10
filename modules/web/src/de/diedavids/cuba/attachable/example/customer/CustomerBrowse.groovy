package de.diedavids.cuba.attachable.example.customer

import com.haulmont.cuba.gui.components.AbstractLookup
import de.balvi.cuba.declarativecontrollers.web.browse.AnnotatableAbstractLookup
import de.diedavids.cuba.attachable.web.HasAttachments

@HasAttachments(listComponent = "customersTable")
class CustomerBrowse extends AnnotatableAbstractLookup {
}