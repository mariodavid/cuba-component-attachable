package de.diedavids.cuba.attachable.web.action

import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.components.AbstractAction
import com.haulmont.cuba.gui.components.Action
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.Window
import groovy.transform.CompileStatic

@CompileStatic
class EditorHasAttachmentsAction extends AbstractAction implements Action.HasOpenType {

    HasAttachmentsBean hasAttachmentsBean = AppBeans.<HasAttachmentsBean> get(HasAttachmentsBean)

    WindowManager.OpenType openType

    protected Window.Editor editor

    EditorHasAttachmentsAction(Window.Editor editor) {
        this(HasAttachmentsBean.ACTION_ID, editor)
    }

    EditorHasAttachmentsAction(String id, Window.Editor editor) {
        super(id)
        this.editor = editor

        updateCaption()
        hasAttachmentsBean.setIcon(this)
    }

    void updateCaption() {
        hasAttachmentsBean.updateCaption(this, editor.item)
    }

    @Override
    void refreshState() {
        super.refreshState()
        updateCaption()
    }

    @Override
    void actionPerform(Component component) {
        hasAttachmentsBean.openAttachmentBrowse(editor.frame, this, editor.item, openType)
    }
}
