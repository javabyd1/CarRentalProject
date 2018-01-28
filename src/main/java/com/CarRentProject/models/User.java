package com.CarRentProject.models;


import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastname;
    private long PESEL;

    public User() {
    }

    public User(int id, String name, String lastname, long PESEL) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.PESEL = PESEL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public long getPESEL() {
        return PESEL;
    }

    public void setPESEL(long PESEL) {
        this.PESEL = PESEL;
    }
}