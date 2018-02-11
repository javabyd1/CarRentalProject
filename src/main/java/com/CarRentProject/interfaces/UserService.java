package com.CarRentProject.interfaces;

import com.CarRentProject.models.Roles;
import com.CarRentProject.models.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);
    User getUsersByFirstName(String firstName);
    User getUserByLastName(String lastName);
    User getUserByLoginAndPassword(String login, String password);
    User getUserByLoginAndPasswordAndRoles(String login, String password, Roles roles);
}
