package com.CarRentProject.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private String userLogin;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> rolesSet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Car> listCar;

    public User() {
    }

    public User(String name, String lastName, String password, int active, Set<Roles> rolesSet, List<Car> listCar, String userLogin) {
        this.name = name;
        this.lastname = lastName;
        this.password = password;
        this.active = active;
        this.rolesSet = rolesSet;
        this.listCar = listCar;
        this.userLogin = userLogin;
    }

    public User(String name, String lastname, String password, String userLogin) {
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.userLogin = userLogin;
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

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}