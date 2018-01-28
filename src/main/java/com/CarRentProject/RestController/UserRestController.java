package com.CarRentProject.RestController;

import com.CarRentProject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserRestController {

    @Autowired
    private UsersServiceImpl usersService;

    @RequestMapping(method = RequestMethod.POST)
    public void addNewUser(User user){
        usersService.addUser(user);
    }
    
}
