package de.diedavids.cuba.attachable.web;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Frame;
import com.haulmont.cuba.gui.components.Window;

public interface WithAttachmentsSupportExecution {

    String NAME = "ddca_WithAttachmentsSupportExecution";

    String ACTION_ID = "attachment";


    Window openAttachmentBrowse(Frame frame, Action action, Entity entity, WindowManager.OpenType openType);

    void updateCaption(Action action, Entity entity);

    void setIcon(Action action);


}
