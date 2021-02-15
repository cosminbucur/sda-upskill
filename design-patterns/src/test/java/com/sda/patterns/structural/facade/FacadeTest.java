package com.sda.patterns.structural.facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FacadeTest {

    @Mock
    public InventoryService inventoryService;

    @Mock
    public PaymentService paymentService;

    @Mock
    public ShippingService shippingService;

    @InjectMocks
    public OrderServiceFacade facade = new OrderServiceFacadeImpl(inventoryService, paymentService, shippingService);

    @Test
    void facadeTest() {
        when(inventoryService.isAvailable(any()))
                .thenReturn(true);
        when(paymentService.makePayment())
                .thenReturn(true);
        doNothing()
                .when(shippingService).shipProduct(any());

        boolean actual = facade.placeOrder(1L);

        assertThat(actual).isTrue();
    }

}