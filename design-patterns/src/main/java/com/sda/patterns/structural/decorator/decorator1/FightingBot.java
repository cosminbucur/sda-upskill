package com.sda.patterns.structural.decorator.decorator1;

public class FightingBot extends Robot {

    public FightingBot() {
        info = "fighting bot";
    }

    @Override
    protected int cost() {
        return 300;
    }
}
