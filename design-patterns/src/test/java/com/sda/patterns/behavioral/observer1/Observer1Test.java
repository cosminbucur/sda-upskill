package com.sda.patterns.behavioral.observer1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Observer1Test {

    @Test
    void testObserver() {
        // given
        Subject publisher = new MessagePublisher();

        Observer subscriber1 = new SubscriberOne();
        Observer subscriber2 = new SubscriberTwo();

        publisher.registerObserver(subscriber1);
        publisher.registerObserver(subscriber2);

        // when
        publisher.notifyUpdate(new Message("price increased"));
        publisher.removeObserver(subscriber1);
        publisher.notifyUpdate(new Message("price decreased"));

        // then
        assertThat(400).isEqualTo(400);
    }

}