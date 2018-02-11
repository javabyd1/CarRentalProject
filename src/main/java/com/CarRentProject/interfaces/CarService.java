package com.CarRentProject.interfaces;

import com.CarRentProject.models.Car;

import java.util.List;

public interface CarService {
    void saveCar(Car car);
    List<Car> getAllCars();
    Car getCarById(Integer id);
    Car getCarByBrand(String brand);
    Car getCarByModel(String model);
    Car getCarByYearOfProduction(int yearOfProduction);
}
