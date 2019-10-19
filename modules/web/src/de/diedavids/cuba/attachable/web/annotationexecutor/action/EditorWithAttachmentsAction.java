package de.diedavids.cuba.attachable.web.annotationexecutor.action;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractAction;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Window;
import de.diedavids.cuba.attachable.web.WithAttachmentsSupportExecution;

public class EditorWithAttachmentsAction extends AbstractAction implements Action.HasOpenType {


    private WithAttachmentsSupportExecution hasAttachmentsBean = AppBeans.get(WithAttachmentsSupportExecution.class);
    private WindowManager.OpenType openType;
    protected Window.Editor editor;

    public EditorWithAttachmentsAction(Window.Editor editor) {
        this(WithAttachmentsSupportExecution.ACTION_ID, editor);
    }

    public EditorWithAttachmentsAction(String id, Window.Editor editor) {
        super(id);
        this.editor = editor;

        updateCaption();
        hasAttachmentsBean.setIcon(this);
    }

    public void updateCaption() {
        hasAttachmentsBean.updateCaption(this, editor.getItem());
    }

    @Override
    public void refreshState() {
        super.refreshState();
        updateCaption();
    }

    @Override
    public void actionPerform(Component component) {
        hasAttachmentsBean.openAttachmentBrowse(editor.getFrame(), this, editor.getItem(), openType);
    }

    public WindowManager.OpenType getOpenType() {
        return openType;
    }

    public void setOpenType(WindowManager.OpenType openType) {
        this.openType = openType;
    }

}
