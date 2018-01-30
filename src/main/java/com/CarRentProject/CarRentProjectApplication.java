package com.CarRentProject;

import com.CarRentProject.models.User;
import com.CarRentProject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentProjectApplication implements CommandLineRunner {

	@Autowired
	UsersServiceImpl usersService;

	public static void main(String[] args) {
		SpringApplication.run(CarRentProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		usersService.saveUser(user);

	}
}
