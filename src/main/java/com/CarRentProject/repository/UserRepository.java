package com.CarRentProject.repository;

import com.CarRentProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByName(String name);
    User findByLastname(String lastname);
    User findByUserLoginAndPassword(String login, String password);

}
