package com.CarRentProject.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Podaj imie")
    private String name;
    @NotEmpty(message = "Podaj nazwisko")
    private String lastname;
    @Length(min = 8, message = "Haslo powinno mieć min 8 znaków")
    @NotEmpty(message = "Podaj haslo")
    private String password;
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> rolesSet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Car>listCar;

    public User() {
    }

    public User(String name, String lastName, String password, int active, Set<Roles> rolesSet, List<Car> listCar) {
        this.name = name;
        this.lastname = lastName;
        this.password = password;
        this.active = active;
        this.rolesSet = rolesSet;
        this.listCar = listCar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Roles> getRolesSet() {
        return rolesSet;
    }

    public void setRolesSet(Set<Roles> rolesSet) {
        this.rolesSet = rolesSet;
    }

    public List<Car> getListCar() {
        return listCar;
    }

    public void setListCar(List<Car> listCar) {
        this.listCar = listCar;
    }
}