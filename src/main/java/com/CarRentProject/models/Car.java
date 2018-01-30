package com.CarRentProject.models;

import javax.persistence.*;

@Entity
@Table (name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private int id;

    private String brand;
    private String model;
    private int yearOfProduction;
    private int priceRentPerDay;
    private boolean ifRented;

    @ManyToOne
    private User user;

    public Car() {
    }

    public Car(String brand, String model, int yearOfProduction, int priceRentPerDay, boolean ifRented) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.priceRentPerDay = priceRentPerDay;
        this.ifRented = ifRented;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getPriceRentPerDay() {
        return priceRentPerDay;
    }

    public void setPriceRentPerDay(int priceRentPerDay) {
        this.priceRentPerDay = priceRentPerDay;
    }

    public boolean isIfRented() {
        return ifRented;
    }

    public void setIfRented(boolean ifRented) {
        this.ifRented = ifRented;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
