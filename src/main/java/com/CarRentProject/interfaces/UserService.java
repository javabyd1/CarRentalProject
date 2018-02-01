package com.CarRentProject.interfaces;

import com.CarRentProject.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);

    User getUsersByName(String name);

    User getUserByLastName(String lastname);
}
