package com.sda.patterns.creational.factory.factory2;

public abstract class Pizza {

    public abstract void addIngredients();

    public void bakePizza() {
        System.out.println("Pizza baked at 180 degree for 20 minutes.");
    }
}
