package com.sda.patterns.structural.proxy.proxy1;

import com.sda.patterns.structural.proxy.AirShip;
import com.sda.patterns.structural.proxy.BatWingProxy;
import com.sda.patterns.structural.proxy.Pilot;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Proxy1Test {

    @Test
    void givenBatman_shouldFly() {
        AirShip batwing = new BatWingProxy(new Pilot("Batman"));

        assertThat(batwing.isFlyable()).isTrue();
    }

    @Test
    void givenJoker_shouldNotFly() {
        AirShip batwing = new BatWingProxy(new Pilot("Joker"));

        assertThat(batwing.isFlyable()).isFalse();
    }

}