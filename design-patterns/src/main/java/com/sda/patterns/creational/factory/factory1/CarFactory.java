package com.sda.patterns.creational.factory.factory1;

public class CarFactory {

    public Car getCar(CarType carType) {

        switch (carType) {
            case ELECTRIC:
                return new ElectricCar();
            case DIESEL:
                return new DieselCar();
            default:
                return null;
        }
    }
}
