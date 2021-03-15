package com.sda.advanced.oop.abstraction;

public abstract class Shape {

    String color;

    // abstract class can have constructor
    Shape(String color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    // abstract methods
    abstract double area();

    // concrete method
    public String getColor() {
        return color;
    }
}
