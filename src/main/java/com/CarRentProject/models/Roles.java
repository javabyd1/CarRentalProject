package com.CarRentProject.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    private String role;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    Set<User> setOfUsers;

    public Roles() {
    }

    public Roles(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getSetOfUsers() {
        return setOfUsers;
    }
}
