package com.sda.advanced.oop.composition;

// COMPOSITION - the composed object cannot exist without the other entity
public class Car {

    // HAS-A
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println("driving");
    }
}
