package com.sda.patterns.creational.factory.factory2;

public class VeggiePizza extends Pizza {

    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for veggie pizza.");
    }
}
