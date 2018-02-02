package com.CarRentProject.repository;

import com.CarRentProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByName(String name);
    User findByLastname(String lastname);

}
