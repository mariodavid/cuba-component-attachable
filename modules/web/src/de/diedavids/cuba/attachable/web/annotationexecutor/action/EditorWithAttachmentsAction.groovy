package de.diedavids.cuba.attachable.web.annotationexecutor.action

import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.components.AbstractAction
import com.haulmont.cuba.gui.components.Action
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.Window
import de.diedavids.cuba.attachable.web.annotationexecutor.WithAttachmentsBean
import groovy.transform.CompileStatic

@CompileStatic
class EditorWithAttachmentsAction extends AbstractAction implements Action.HasOpenType {

    WithAttachmentsBean hasAttachmentsBean = AppBeans.<WithAttachmentsBean> get(WithAttachmentsBean)

    WindowManager.OpenType openType

    protected Window.Editor editor

    EditorWithAttachmentsAction(Window.Editor editor) {
        this(WithAttachmentsBean.ACTION_ID, editor)
    }

    EditorWithAttachmentsAction(String id, Window.Editor editor) {
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
