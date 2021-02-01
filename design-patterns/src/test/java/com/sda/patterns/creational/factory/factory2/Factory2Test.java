package com.sda.patterns.creational.factory.factory2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Factory2Test {

    @Test
    void givenBuilders_whenBuild_thenReturnOk() {
        // given
        BasePizzaFactory pizzaFactory = new PizzaFactory();

        // when
        Pizza cheesePizza = pizzaFactory.createPizza("cheese");
        Pizza veggiePizza = pizzaFactory.createPizza("veggie");

        // then
        assertThat(cheesePizza).isInstanceOf(CheesePizza.class);
        assertThat(veggiePizza).isInstanceOf(VeggiePizza.class);
    }
}