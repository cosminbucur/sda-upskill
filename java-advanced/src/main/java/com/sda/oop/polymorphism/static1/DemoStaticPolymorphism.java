package com.sda.oop.polymorphism.static1;

public class DemoStaticPolymorphism {

    public static void main(String[] args) {
        // reference of type Human = object of type Boy
        Human boy = new Boy();

        // reference of type Human = object of type Human
        Human human = new Human();
    }
}
