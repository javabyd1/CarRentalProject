package com.CarRentProject.controllers;

import com.CarRentProject.models.Car;
import com.CarRentProject.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarRestController {

    @Autowired
    CarServiceImpl carService;



    @GetMapping(value = "/listOfCars")
    public List<Car> getListOfCars() {
        return carService.getAllCars();
    }

    @PostMapping(value = "/addCar")
    public void addCar(Car car) {
        carService.saveCar(car);
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public ModelAndView cars() {
        ModelAndView mav = new ModelAndView("cars");
        mav.addObject("cars", carService.getAllCars());
        mav.addObject("car", new Car());
        return mav;
    }





}
