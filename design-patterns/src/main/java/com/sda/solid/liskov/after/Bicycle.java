package com.sda.solid.liskov.after;

public class Bicycle extends DeviceWithoutEngine {

    @Override
    void startMoving() {
        System.out.println("bike starts moving");
    }
}
