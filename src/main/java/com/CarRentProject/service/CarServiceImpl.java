package com.CarRentProject.service;

import com.CarRentProject.interfaces.CarService;
import com.CarRentProject.models.Car;
import com.CarRentProject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car getCarbyBrand(String brand) {
        return null;
    }

    @Override
    public Car getCarByModel(String model) {
        return null;
    }

    @Override
    public Car getCarByYearOfProduction(int yearOfProduction) {
        return null;
    }
}
