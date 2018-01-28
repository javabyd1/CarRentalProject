package com.CarRentProject.models;



public class User {
    private String name;
    private String lastname;
    private long PESEL;

    public User() {
    }

    public User(String name, String lastname, long PESEL) {
        this.name = name;
        this.lastname = lastname;
        this.PESEL = PESEL;
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
