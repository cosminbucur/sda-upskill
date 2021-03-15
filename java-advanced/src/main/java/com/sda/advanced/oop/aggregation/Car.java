package com.sda.advanced.oop.aggregation;

// AGGREGATION - unidirectional association
public class Car {

    // can be multiple passengers
    // HAS-A
    private Driver driver;

    public void drive() {
        System.out.println(driver + " driving");
    }

    public void setPassenger(Driver driver) {
        this.driver = driver;
    }
}
