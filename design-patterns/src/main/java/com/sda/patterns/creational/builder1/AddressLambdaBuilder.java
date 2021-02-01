package com.sda.patterns.creational.builder1;

import java.util.function.Consumer;

public class AddressLambdaBuilder {

    public String city;
    public String state;
    public String street;
    public String pin;

    public AddressLambdaBuilder with(Consumer<AddressLambdaBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public Address createAddress() {
        return new Address(city, state, street, pin);
    }
}
