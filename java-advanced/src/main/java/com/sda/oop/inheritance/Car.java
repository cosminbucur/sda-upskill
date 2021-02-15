package com.sda.oop.inheritance;

// is-a relationship
public class Car extends Vehicle {

    public int fillTank(int amount) {
        return super.tankCapacity + amount;
    }
}