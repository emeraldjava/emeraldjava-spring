package ie.emeraldjava.vaadin.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://stackoverflow.com/questions/76278722/how-to-add-vaadin-to-an-existing-spring-boot-project-and-make-vaadin-actually-st
 */
@Route
@AnonymousAllowed
public class MainView extends VerticalLayout {

    Grid<Contact> grid = new Grid<>(Contact.class);
    TextField filterText = new TextField();
    private ContactForm form;

    public MainView() {
        addClassName("list-view");
        setSizeFull();
        //configureGrid();
        configureForm();
        //add(getToolbar(), getContent());#
        add(getContent());
        
        list();
    }

    private void list() {
        grid.setItems(form.contacts);
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureForm() {
        form = new ContactForm();//ßCollections.emptyList(), Collections.emptyList());
        form.setWidth("25em");
    }
}
