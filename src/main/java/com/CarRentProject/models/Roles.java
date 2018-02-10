package com.CarRentProject.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Roles implements Serializable{

    @Enumerated(EnumType.STRING)
    private Role role;
}
