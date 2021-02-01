package com.sda.patterns.creational.builder1;

public class Person {
    private final String salutation;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String suffix;
    private final Address address;
    private final boolean isFemale;
    private final boolean isEmployed;
    private final boolean isHomeOwner;


    public Person(String salutation, String firstName, String middleName, String lastName, String suffix, Address address, boolean isFemale, boolean isEmployed, boolean isHomeOwner) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.address = address;
        this.isFemale = isFemale;
        this.isEmployed = isEmployed;
        this.isHomeOwner = isHomeOwner;
    }
}