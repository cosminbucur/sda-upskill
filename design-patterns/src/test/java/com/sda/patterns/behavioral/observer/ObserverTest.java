package com.sda.patterns.behavioral.observer;

import org.junit.jupiter.api.Test;

class ObserverTest {

    @Test
    void testObserver() {
        // given
        Subject product = new Product("Smart phone", 500);

        Observer customer1 = new Customer("alex@gmail.com");
        Observer customer2 = new Customer("ana@gmail.com");
        Observer customer3 = new Customer("paul@gmail.com");

        product.registerObserver(customer1);
        product.registerObserver(customer2);
        product.registerObserver(customer3);

        // when
        product.setPrice(customer1, 480);
        product.removeObserver(customer2);
        product.setPrice(customer3, 480);

        // then
//        assertThat().isEqualTo(400);
    }

}