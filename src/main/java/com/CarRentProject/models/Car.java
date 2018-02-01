package com.CarRentProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private int id;

    private String brand;
    private String model;
    private int yearOfProduction;
    private int priceRentPerDay;
    private boolean isRented;

    @ManyToOne
    private User user;

    public Car() {
    }

    public Car(String brand, String model, int yearOfProduction, int priceRentPerDay, boolean isRented) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.priceRentPerDay = priceRentPerDay;
        this.isRented = isRented;
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

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        this.isRented = rented;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
