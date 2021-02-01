package com.sda.patterns.creational.builder1;

import java.util.function.Consumer;

public class PersonLambdaBuilder {

    public String salutation;
    public String firstName;
    public String middleName;
    public String lastName;
    public String suffix;
    public Address address;
    public boolean isFemale;
    public boolean isEmployed;
    public boolean isHomeOwner;

    public PersonLambdaBuilder with(Consumer<PersonLambdaBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public Person createPerson() {
        return new Person(salutation, firstName, middleName, lastName, suffix,
                address, isFemale, isEmployed, isHomeOwner);
    }
}
