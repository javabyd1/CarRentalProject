package com.CarRentProject.repository;

import com.CarRentProject.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findAllByBrand(String brand);
    Car findAllByModel(String model);
    Car findAllByYearOfProduction(int yearOfProduction);
    Car findAllByPriceRentPerDay(int priceRentPerDay);
    Car findAllByIsRented(boolean isRented);

    @Override
    List<Car> findAll();
}

