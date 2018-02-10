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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class AdminPagesController {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    CarServiceImpl carsService;

    @PostMapping("/save-car")
    public String saveNewCar(@ModelAttribute("car") @Valid Car car) {
        carsService.saveCar(car);
        return "redirect:/cars";
    }


    @GetMapping("/users")
    public ModelAndView users() {
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("users", usersService.getAllUsers());
        return mav;
    }

}
