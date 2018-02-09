package de.diedavids.cuba.attachable.web.customer

import de.balvi.cuba.declarativecontrollers.web.browse.AnnotatableAbstractLookup
import de.diedavids.cuba.attachable.web.HasAttachments

@HasAttachments(listComponent = 'customersTable')
class CustomerBrowse extends AnnotatableAbstractLookup {
}