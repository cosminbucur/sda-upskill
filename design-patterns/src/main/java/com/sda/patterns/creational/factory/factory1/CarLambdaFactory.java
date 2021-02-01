package com.sda.patterns.creational.factory.factory1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CarLambdaFactory {

    private static final Map<CarType, Supplier<Car>> carMap = new HashMap<>();

    static {
        carMap.put(CarType.ELECTRIC, () -> new ElectricCar());
        carMap.put(CarType.DIESEL, DieselCar::new);
    }

    public Car getCar(CarType carType) {
        Supplier<Car> car = carMap.get(carType);

        if (car != null) {
            return car.get();
        }

        throw new IllegalArgumentException("Car not available!");
    }

}
