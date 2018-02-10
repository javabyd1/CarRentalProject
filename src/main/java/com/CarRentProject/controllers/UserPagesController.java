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
public class UserPagesController {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    CarServiceImpl carsService;

    @GetMapping("/my-cars")
    public ModelAndView listOfUsersCars(HttpSession session) {
        User user = (User) session.getAttribute("user");

        ModelAndView mav = new ModelAndView("mycars");
        mav.addObject("allCars", carsService.getAllCars());
        mav.addObject("userCars", user.getListOfCars());
        mav.addObject("car", new Car());
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public ModelAndView cars() {
        ModelAndView mav = new ModelAndView("cars");
        mav.addObject("cars", carsService.getAllCars());
        mav.addObject("car", new Car());
        return mav;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("cars", carsService.getAllCars());
        return mav;
    }

}
