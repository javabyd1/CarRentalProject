package com.CarRentProject.repository;

import com.CarRentProject.models.Roles;
import com.CarRentProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByFirstName(String firstName);
    User findByLastName(String lastName);
    User findByLoginAndPassword(String login, String password);
    User findByLoginAndPasswordAndRoles(String login, String password, Roles roles);

}
