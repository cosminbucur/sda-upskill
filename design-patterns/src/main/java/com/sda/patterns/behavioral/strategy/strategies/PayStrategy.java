package com.sda.patterns.behavioral.strategy.strategies;

public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
