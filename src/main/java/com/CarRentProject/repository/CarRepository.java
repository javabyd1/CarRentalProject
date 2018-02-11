package com.CarRentProject.repository;

import com.CarRentProject.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findById(Integer id);
    Car findAllByBrand(String brand);
    Car findAllByModel(String model);
    Car findAllByYearOfProduction(int yearOfProduction);

    @Override
    List<Car> findAll();

}

