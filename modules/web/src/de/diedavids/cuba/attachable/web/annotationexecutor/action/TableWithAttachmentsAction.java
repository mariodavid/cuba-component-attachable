package de.diedavids.cuba.attachable.web.annotationexecutor.action;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction;
import de.diedavids.cuba.attachable.web.WithAttachmentsSupportExecution;

public class TableWithAttachmentsAction extends ItemTrackingAction implements Action.HasOpenType {


    private WithAttachmentsSupportExecution withAttachmentsSupportExecution = AppBeans.get(WithAttachmentsSupportExecution.class);
    private WindowManager.OpenType openType;

    public TableWithAttachmentsAction(ListComponent target, WindowManager.OpenType openType) {
        this(WithAttachmentsSupportExecution.ACTION_ID, target);
    }

    public TableWithAttachmentsAction(String id, ListComponent target) {
        super(target, id);

        updateCaption();
        withAttachmentsSupportExecution.setIcon(this);
    }

    public void updateCaption() {
        withAttachmentsSupportExecution.updateCaption(this, getTarget().getSingleSelected());
    }

    @Override
    public void refreshState() {
        super.refreshState();
        updateCaption();
    }

    @Override
    public void actionPerform(Component component) {
        withAttachmentsSupportExecution.openAttachmentBrowse(getTarget().getFrame(), this, getTarget().getSingleSelected(), openType);
    }


    public WindowManager.OpenType getOpenType() {
        return openType;
    }

    public void setOpenType(WindowManager.OpenType openType) {
        this.openType = openType;
    }

}
