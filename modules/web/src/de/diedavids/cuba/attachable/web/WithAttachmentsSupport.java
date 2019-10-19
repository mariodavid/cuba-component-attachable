package de.diedavids.cuba.attachable.web;

import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.components.actions.ListAction;
import com.haulmont.cuba.gui.screen.Extensions;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import de.balvi.cuba.declarativecontrollers.web.helper.ButtonsPanelHelper;
import de.diedavids.cuba.attachable.web.annotationexecutor.action.TableWithAttachmentsAction;

import java.util.Collections;

public interface WithAttachmentsSupport {

    /**
     * defines the list component that will be used as a basis for the attachment functionality
     *
     * @return the list component
     */
    ListComponent getListComponentForAttachments();

    /**
     * the button id of the destination button
     * <p>
     * It will either picked up from existing XML definitions or created with this identifier
     *
     * @return the button identifier
     */
    default String getButtonIdForAttachments() {
        return "attachmentsBtn";
    }


    /**
     * defines the button panel that will be used for inserting the attachments button
     *
     * @return the destination buttonPanel
     */
    ButtonsPanel getButtonsPanelForAttachments();


    /**
     * option to configure the option type of the tag link
     */
    default WindowManager.OpenType attachmentListOpenType() {
        return WindowManager.OpenType.DIALOG;
    }

    @Subscribe
    default void initAttachmentsButton(Screen.InitEvent event) {

        Screen screen = event.getSource();
        Button button = createOrGetButton(screen);

        ListAction action = new TableWithAttachmentsAction(
                getListComponentForAttachments(),
                attachmentListOpenType()
        );
        getListComponentForAttachments().addAction(action);
        button.setAction(action);

    }

    default Button createOrGetButton(Screen screen) {
        BeanLocator beanLocator = getBeanLocator(screen);
        ButtonsPanelHelper buttonsPanelHelper = beanLocator.get(ButtonsPanelHelper.NAME);
        return buttonsPanelHelper.createButton(getButtonIdForAttachments(), getButtonsPanelForAttachments(), Collections.emptyList());
    }

    default BeanLocator getBeanLocator(Screen screen) {
        return Extensions.getBeanLocator(screen);
    }

}