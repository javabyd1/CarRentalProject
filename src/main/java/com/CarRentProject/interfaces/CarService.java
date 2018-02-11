package com.CarRentProject.interfaces;

import com.CarRentProject.models.Car;
import com.CarRentProject.models.User;

import java.util.List;

public interface CarService {
    void saveCar(Car car);
    List<Car> getAllCars();
    Car getCarById(Long id);
    Car getCarByBrand(String brand);
    Car getCarByModel(String model);
    Car getCarByYearOfProduction(int yearOfProduction);
    List<Car> getAllCarsByUser(User user);
}
