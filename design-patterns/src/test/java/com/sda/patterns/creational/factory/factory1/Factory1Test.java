package com.sda.patterns.creational.factory.factory1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Factory1Test {

    @Test
    void givenFactory_whenGetCar_thenReturnCorrectInstance() {
        // given
        CarFactory carFactory = new CarFactory();

        // when
        Car electricCar = carFactory.getCar(CarType.ELECTRIC);
        Car dieselCar = carFactory.getCar(CarType.DIESEL);

        // then
        assertThat(electricCar).isInstanceOf(ElectricCar.class);
        assertThat(dieselCar).isInstanceOf(DieselCar.class);
    }

    @Test
    void givenLambdaFactory_whenGetCar_thenReturnCorrectInstance() {
        // given
        CarLambdaFactory carFactory = new CarLambdaFactory();

        // when
        Car electricCar = carFactory.getCar(CarType.ELECTRIC);
        Car dieselCar = carFactory.getCar(CarType.DIESEL);

        // then
        assertThat(electricCar).isInstanceOf(ElectricCar.class);
        assertThat(dieselCar).isInstanceOf(DieselCar.class);
    }
}