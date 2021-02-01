package com.sda.patterns.creational.builder1;

public class AddressBuilder {

    private String city;
    private String state;
    private String street;
    private String pin;

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder withPin(String pin) {
        this.pin = pin;
        return this;
    }

    public Address createAddress() {
        return new Address(city, state, street, pin);
    }
}
