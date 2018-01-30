package com.CarRentProject.repository;

import com.CarRentProject.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    public Car findAllByBrand(String brand);
    public Car findAllByModel(String model);
    public Car findAllByYearOfProduction(int yearOfProduction);
    public Car findAllByPriceRentPerDay(int priceRentPerDay);
    public Car findAllByIfRented(boolean ifRented);
}

