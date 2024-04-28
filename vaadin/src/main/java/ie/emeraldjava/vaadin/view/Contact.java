package ie.emeraldjava.vaadin.view;

import com.vaadin.flow.router.Route;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {

    private String firstName;
    private String lastName;
    private String email;
}
