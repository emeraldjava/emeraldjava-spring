package ie.emeraldjava.vaadin.view;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ContactForm extends FormLayout {

    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    EmailField email = new EmailField("Email");
    //ComboBox<Status> status = new ComboBox<>("Status");
//    ComboBox<Company> company = new ComboBox<>("Company");

    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Contact> binder = new Binder<>(Contact.class);

    List<Contact> contacts = new ArrayList<>();

    public ContactForm() {//List<Company> companies, List<Status> statuses) {
        addClassName("contact-form");
//        company.setItems(companies);
//        company.setItemLabelGenerator(Company::getName);
//        status.setItems(statuses);
//        status.setItemLabelGenerator(Status::getName);

        this.contacts.add(Contact.builder().firstName("fname").lastName("lname").build());
        add(firstName,
                lastName,
                email,
//                company,
  //              status,
                createButtonsLayout());

        //binder.bindInstanceFields(this);

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        save.addClickListener(e -> save());
    }

    void save() {
        log.info("save()");
        //this.contacts.add(contact);
     //   repository.save(customer);
       // changeHandler.onChange();
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);
        return new HorizontalLayout(save, delete, close);
    }
}
