package ie.emeraldjava.spring.rest.service;

import ie.emeraldjava.spring.rest.api.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by pauloconnell on 18/04/17.
 */
public interface UserService {

    User findById(Long id);

    List<User> findAllUsers();

    Boolean isUserExist(User user);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    void deleteAllUsers();

}
