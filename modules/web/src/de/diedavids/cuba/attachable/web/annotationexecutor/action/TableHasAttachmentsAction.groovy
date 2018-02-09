package de.diedavids.cuba.attachable.web.annotationexecutor.action

import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.components.Action
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.ListComponent
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction
import de.diedavids.cuba.attachable.web.annotationexecutor.HasAttachmentsBean
import groovy.transform.CompileStatic

@CompileStatic
class TableHasAttachmentsAction extends ItemTrackingAction implements Action.HasOpenType {

    HasAttachmentsBean hasAttachmentsBean = AppBeans.<HasAttachmentsBean> get(HasAttachmentsBean)

    WindowManager.OpenType openType

    TableHasAttachmentsAction(ListComponent target) {
        this(HasAttachmentsBean.ACTION_ID, target)
    }

    TableHasAttachmentsAction(String id, ListComponent target) {
        super(target, id)

        updateCaption()
        hasAttachmentsBean.setIcon(this)
    }

    void updateCaption() {
        hasAttachmentsBean.updateCaption(this, target.singleSelected)
    }

    @Override
    void refreshState() {
        super.refreshState()
        updateCaption()
    }

    @Override
    void actionPerform(Component component) {
        hasAttachmentsBean.openAttachmentBrowse(target.frame, this, target.singleSelected, openType)
    }
}
