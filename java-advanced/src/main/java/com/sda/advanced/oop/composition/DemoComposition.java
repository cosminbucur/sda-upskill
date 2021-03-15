package com.sda.advanced.oop.composition;

public class DemoComposition {

    public static void main(String[] args) {
        Car car = new Car(new Engine());
        car.drive();
    }
}
