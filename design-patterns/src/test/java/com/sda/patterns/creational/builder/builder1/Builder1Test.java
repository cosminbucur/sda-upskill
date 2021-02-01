package com.sda.patterns.creational.builder.builder1;

import com.sda.patterns.creational.builder1.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Builder1Test {

    @Test
    void givenClassicBuilder_whenBuild_thenReturnOk() {
        // given

        // when
        Person actual = new PersonBuilder()
                .withSalutation("Mr.")
                .withFirstName("John")
                .withLastName("Doe")
                .withIsFemale(false)
                .withAddress(new AddressBuilder()
                        .withCity("Pune")
                        .withState("MH")
                        .withStreet("MG Road")
                        .withPin("411001")
                        .createAddress())
                .createPerson();

        // then
        assertThat(actual).isNotNull();
    }

    @Test
    void givenLambdaBuilder_whenBuild_thenReturnOk() {
        // given

        // when
        Person actual = new PersonLambdaBuilder()
                .with(personLambdaBuilder -> {
                    personLambdaBuilder.salutation = "Mr.";
                    personLambdaBuilder.firstName = "John";
                    personLambdaBuilder.lastName = "Doe";
                    personLambdaBuilder.isFemale = false;
                    personLambdaBuilder.address = new AddressLambdaBuilder()
                            .with(addressLambdaBuilder -> {
                                addressLambdaBuilder.city = "city";
                                addressLambdaBuilder.state = "state";
                                addressLambdaBuilder.street = "street";
                                addressLambdaBuilder.pin = "123";
                            })
                            .createAddress();
                })
                .createPerson();

        // then
        assertThat(actual).isNotNull();
    }
}