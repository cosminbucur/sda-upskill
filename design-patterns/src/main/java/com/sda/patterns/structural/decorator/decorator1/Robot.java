package com.sda.patterns.structural.decorator.decorator1;

// the component
public abstract class Robot {

    String info;

    public String getInfo() {
        return info;
    }

    protected abstract int cost();
}
