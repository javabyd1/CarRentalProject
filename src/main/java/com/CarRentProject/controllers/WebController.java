package com.CarRentProject.controllers;

import com.CarRentProject.models.Car;
import com.CarRentProject.models.User;
import com.CarRentProject.service.CarServiceImpl;
import com.CarRentProject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class WebController {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    CarServiceImpl carsService;

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/register")
    public String saveNewUser(@ModelAttribute("user") @Valid User user) {
        usersService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/carsForRent")
    public ModelAndView showListOfCarsForRent() {
        ModelAndView modelAndView = new ModelAndView("carsForRent");
        modelAndView.addObject("car", new Car());
        return modelAndView;
    }

    @RequestMapping(value = "car", method = RequestMethod.GET)
    public ModelAndView cars() {
        ModelAndView mav = new ModelAndView("cars");
        mav.addObject("cars", carsService.getAllCars());
        return mav;
    }
}
