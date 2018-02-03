package com.CarRentProject.interfaces;

import com.CarRentProject.models.Car;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {

    List<Car>getAllCars();
    void saveCar(Car car);
    Car getCarbyBrand(String brand);
    Car getCarByModel(String model);
    Car getCarByYearOfProduction(int yearOfProduction);
    Car getCarByPriceRentPerDay(int priceRentPerDay);
    Car getCarByIsRented(boolean isRented);
}
