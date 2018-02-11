package com.CarRentProject.controllers;

import com.CarRentProject.models.Roles;
import com.CarRentProject.models.User;
import com.CarRentProject.repository.RolesRepository;
import com.CarRentProject.service.CarServiceImpl;
import com.CarRentProject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class RegisterController {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    CarServiceImpl carsService;

    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/register")
    public String saveNewUser(@ModelAttribute("user") @Valid User user) {
        Roles role = rolesRepository.findByRole("user");
        user.setRoles(role);
        usersService.saveUser(user);
        return "redirect:/login";
    }

}
