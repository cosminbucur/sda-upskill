package com.sda.patterns.structural.decorator.decorator1;

public class RepairBot extends Robot {

    public RepairBot() {
        info = "repair bot";
    }

    @Override
    protected int cost() {
        return 100;
    }
}
