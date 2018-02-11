package com.CarRentProject.repository;

import com.CarRentProject.models.Car;
import com.CarRentProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findById(Long id);
    Car findAllByBrand(String brand);
    Car findAllByModel(String model);
    Car findAllByYearOfProduction(int yearOfProduction);
    List<Car> findAllByUser(User user);

    @Override
    List<Car> findAll();

}

