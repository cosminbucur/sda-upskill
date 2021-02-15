package com.sda.patterns.behavioral.strategy;

import com.sda.patterns.behavioral.strategy.order.Order;
import com.sda.patterns.behavioral.strategy.strategies.PayByPayPal;
import com.sda.patterns.behavioral.strategy.strategies.PayStrategy;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyTest {

    @Test
    void givenPayPal_whenProcessOrder_thenOk() {
        // given
        Map<String, Integer> priceOnProducts = Map.of(
                "Mother board", 400,
                "CPU", 300,
                "HDD", 200,
                "RAM", 100
        );

        Order order = new Order();
        PayStrategy strategy = new PayByPayPal();

        // when
        order.processOrder(strategy);

        // then
        assertThat(order.getTotalCost()).isEqualTo(400);
    }

}