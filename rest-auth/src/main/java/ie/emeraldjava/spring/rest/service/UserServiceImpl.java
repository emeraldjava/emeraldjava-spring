package ie.emeraldjava.spring.rest.service;

import ie.emeraldjava.spring.rest.api.User;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by pauloconnell on 18/04/17.
 */
public class UserServiceImpl implements UserService {

    private Map<Long,User> users;

    @PostConstruct
    public void postConstruct() {
        this.users = new HashMap<Long,User>();
    }

    @Override
    public User findById(Long id) {
        if(this.users.containsKey(id))
            return this.users.get(id);
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList(this.users.values());
    }

    @Override
    public Boolean isUserExist(User user) {
        return this.users.containsKey(user.getId());
    }

    @Override
    public void saveUser(User user) {
        this.users.put(user.getId(),user);
        System.out.println("saveUser() " + this.users.size());
    }

    @Override
    public void updateUser(User user) {
        System.out.println("updateUser() "+user);
        this.users.replace(user.getId(), user);
    }

    @Override
    public void deleteUserById(Long id) {
        System.out.println("deleteUserById() "+id);
        this.users.remove(id);
    }

    @Override
    public void deleteAllUsers() {
//        this.users.remove();
    }
}
