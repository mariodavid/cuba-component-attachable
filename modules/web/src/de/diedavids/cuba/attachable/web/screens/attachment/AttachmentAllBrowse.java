package de.diedavids.cuba.attachable.web.screens.attachment;

import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.attachable.entity.Attachment;
import de.diedavids.cuba.entitysoftreference.web.SoftReferenceInstanceNameTableColumnGenerator;

import javax.inject.Inject;

@UiController("ddca$AttachmentAll.browse")
@UiDescriptor("attachment-all-browse.xml")
@LookupComponent("attachmentsTable")
@LoadDataBeforeShow
public class AttachmentAllBrowse extends StandardLookup<Attachment> {

    @Inject
    protected GroupTable<Attachment> attachmentsTable;
    @Inject
    protected UiComponents uiComponents;
    @Inject
    protected MetadataTools metadataTools;
    @Inject
    protected ScreenBuilders screenBuilders;

    @Subscribe
    protected void onInit(InitEvent event) {
        attachmentsTable.addGeneratedColumn("attachable",
                new SoftReferenceInstanceNameTableColumnGenerator(
                        "attachable",
                        uiComponents,
                        metadataTools,
                        screenBuilders,
                        this
                )
        );
    }
    
    
}