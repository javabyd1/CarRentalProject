package com.CarRentProject;

import com.CarRentProject.models.Car;
import com.CarRentProject.models.User;
import com.CarRentProject.service.CarServiceImpl;
import com.CarRentProject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentProjectApplication implements CommandLineRunner {

	@Autowired
    UsersServiceImpl usersService;

	@Autowired
    CarServiceImpl carService;

	public static void main(String[] args) {
		SpringApplication.run(CarRentProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User admin = new User("admin", "123", "admin", "admin");
		usersService.saveUser(admin);

        Car audi = new Car("Audi", "A9", 2017);
        carService.saveCar(audi);
        Car toyota = new Car("Toyota", "Corolla", 2014);
        carService.saveCar(toyota);
	}
}
