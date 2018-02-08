package com.CarRentProject.interfaces;

import com.CarRentProject.models.Car;

import java.util.List;


public interface CarService {

    List<Car> getAllCars();

    void saveCar(Car car);

    Car getCarbyBrand(String brand);

    Car getCarByModel(String model);

    Car getCarByYearOfProduction(int yearOfProduction);
}
