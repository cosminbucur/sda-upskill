package com.sda.patterns.structural.proxy;

public class BatWing implements AirShip {

    @Override
    public boolean isFlyable() {
        System.out.println("welcome Batman. let's fly!");
        return true;
    }
}
