package com.sda.patterns.creational.builder1;

public class Address {

    private final String city;
    private final String state;
    private final String street;
    private final String pin;

    public Address(String city, String state, String street, String pin) {
        this.city = city;
        this.state = state;
        this.street = street;
        this.pin = pin;
    }
}
