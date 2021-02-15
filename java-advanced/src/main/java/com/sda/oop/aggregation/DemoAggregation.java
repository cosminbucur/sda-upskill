package com.sda.oop.aggregation;

// both the entries can survive individually which means ending one entity will not effect the other entity
public class DemoAggregation {

    public static void main(String[] args) {
        Car car = new Car();

        Driver driver1 = new Driver();
        Driver driver2 = new Driver();
        car.setPassenger(driver1);
        car.drive();
        car.setPassenger(driver2);
        car.drive();
    }
}
