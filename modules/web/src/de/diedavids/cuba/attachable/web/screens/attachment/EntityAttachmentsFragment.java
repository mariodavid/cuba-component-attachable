package de.diedavids.cuba.attachable.web.screens.attachment;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.attachable.entity.Attachment;

import javax.inject.Inject;


/**
 * Fragment for displaying all Attachments for a given Entity.
 *
 * It renders a CRUD table of Attachments with the ability to
 *
 * - create an Attachment
 * - edit an Attachment
 * - remove an Attachment
 *
 * -----------------------------------------------------------
 *
 * Parameters
 *
 * - attachableDc (required): InstanceDataContainer that holds the entity
 *
 *
 * Example Usage
 *
 * <fragment screen="ddca_EntityAttachmentsFragment">
 *     <properties>
 *         <property name="attachableDc" ref="customerDc"/>
 *     </properties>
 * </fragment>
 */
@UiController("ddca_EntityAttachmentsFragment")
@UiDescriptor("entity-attachments-fragment.xml")
public class EntityAttachmentsFragment extends ScreenFragment {

    @Inject
    protected CollectionLoader<Attachment> attachmentsDl;
    @Inject
    protected ScreenBuilders screenBuilders;
    @Inject
    protected Table<Attachment> attachmentsTable;

    private InstanceContainer<? extends Entity> attachableDc;


    /**
     * sets the required Attribute 'attachableDc'
     * @param attachableDc
     */
    public void setAttachableDc(InstanceContainer<? extends Entity> attachableDc) {
        this.attachableDc = attachableDc;
    }


    @Subscribe(target = Target.PARENT_CONTROLLER)
    private void onAfterShowHost(Screen.AfterShowEvent event) {

        if (attachableDc == null) {
            throw new MissingFragmentParameterException(
              "Fragment Parameter 'attachableDc' not provided"
            );
        }

        if (attachableDc.getItem() == null) {
            throw new IllegalStateException(
              "Fragment Parameter 'attachableDc' has no item attached"
            );
        }

        attachmentsDl.setParameter("attachable", attachableDc.getItem());
        attachmentsDl.load();
    }

    @Subscribe("attachmentsTable.create")
    protected void onAttachmentsTableCreate(Action.ActionPerformedEvent event) {
        screenBuilders.editor(attachmentsTable)
                .newEntity()
                .withInitializer(attachment -> attachment.setAttachable(attachableDc.getItem()))
                .show();
    }

}