package com.sda.oop.inheritance;

public class Vehicle {

    int tankCapacity;

    // abstract method - must be implemented by children
    public int fillTank(int amount) {
        return tankCapacity + amount;
    }

    // regular method - can be overloaded or overridden
    public void drive() {
        System.out.println("just driving");
    }

}
