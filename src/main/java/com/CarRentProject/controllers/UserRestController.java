package com.CarRentProject.controllers;

import com.CarRentProject.models.User;
import com.CarRentProject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UsersServiceImpl usersService;

    @RequestMapping(method = RequestMethod.POST)
    public void addNewUser(User user){
        usersService.saveUser(user);
    }

    @GetMapping
    public List<User> get() {
        System.out.println("dziala");
        return usersService.getAllUsers();
    }
    
}
