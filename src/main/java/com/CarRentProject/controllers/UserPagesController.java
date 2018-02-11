package com.CarRentProject.controllers;

import com.CarRentProject.models.Car;
import com.CarRentProject.models.User;
import com.CarRentProject.service.CarServiceImpl;
import com.CarRentProject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class UserPagesController {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    CarServiceImpl carsService;

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("cars", carsService.getAllCars());
        return mav;
    }

    @GetMapping("/my-cars")
    public ModelAndView listOfUsersCars(HttpSession session) {
        User loggedUser = (User) session.getAttribute("user");
        loggedUser = usersService.getUserByLoginAndPassword(loggedUser.getLogin(), loggedUser.getPassword());

        ModelAndView mav = new ModelAndView("mycars");
        mav.addObject("allCars", carsService.getAllCars());
        mav.addObject("userCars", loggedUser.getListOfCars());
        mav.addObject("car", new Car());
        mav.addObject("user", loggedUser);
        return mav;
    }

    @GetMapping("/rent-cars")
    public ModelAndView listOfCarsToRent() {
        ModelAndView mav = new ModelAndView("rentcars");
        mav.addObject("availableCars", carsService.getAllCarsByUser(null));
        mav.addObject("carToRent", new Car());
        return mav;
    }

    @PostMapping("/rent-cars")
    public String rentCar(HttpSession session, @RequestBody MultiValueMap<String, String> formParams) {
        User loggedUser = (User) session.getAttribute("user");
        loggedUser = usersService.getUserByLoginAndPassword(loggedUser.getLogin(), loggedUser.getPassword());

        Car carToRent = carsService.getCarById(Long.parseLong(formParams.getFirst("id")));
        carToRent.setUser(loggedUser);
        carsService.saveCar(carToRent);

        return "redirect:/my-cars";
    }

    @GetMapping("/cars")
    public ModelAndView cars() {
        ModelAndView mav = new ModelAndView("cars");
        mav.addObject("cars", carsService.getAllCars());
        mav.addObject("car", new Car());
        return mav;
    }

}
