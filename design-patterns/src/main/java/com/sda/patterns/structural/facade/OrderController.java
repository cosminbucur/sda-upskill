package com.sda.patterns.structural.facade;

public class OrderController {

    private OrderServiceFacade facade;

    public boolean orderProduct(long productId) {
        System.out.println("controller: order completed");
        return facade.placeOrder(productId);
    }
}
