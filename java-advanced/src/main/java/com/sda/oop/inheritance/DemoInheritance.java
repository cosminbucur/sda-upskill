package com.sda.oop.inheritance;

public class DemoInheritance {

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.fillTank(50);
        vehicle.drive();

        Car car = new Car();
        car.fillTank(100);
    }
}
