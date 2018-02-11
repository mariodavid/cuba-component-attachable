package de.diedavids.cuba.attachable.web.annotationexecutor.action

import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.components.Action
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.ListComponent
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction
import de.diedavids.cuba.attachable.web.annotationexecutor.WithAttachmentsBean
import groovy.transform.CompileStatic

@CompileStatic
class TableWithAttachmentsAction extends ItemTrackingAction implements Action.HasOpenType {

    WithAttachmentsBean hasAttachmentsBean = AppBeans.<WithAttachmentsBean> get(WithAttachmentsBean)

    WindowManager.OpenType openType

    TableWithAttachmentsAction(ListComponent target) {
        this(WithAttachmentsBean.ACTION_ID, target)
    }

    TableWithAttachmentsAction(String id, ListComponent target) {
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
