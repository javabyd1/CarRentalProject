package com.CarRentProject.repository;

import com.CarRentProject.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository <Roles, Long>{

    Roles findAllByRole(String role);
}
