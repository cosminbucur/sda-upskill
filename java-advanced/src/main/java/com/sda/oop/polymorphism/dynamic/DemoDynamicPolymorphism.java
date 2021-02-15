package com.sda.oop.polymorphism.dynamic;

public class DemoDynamicPolymorphism {

    public static void main(String[] args) {
        // dynamic means method behavior changes at runtime
        Animal animal = new Animal();
        animal.walk();

        Animal dog = new Dog();
        dog.walk();
    }
}
