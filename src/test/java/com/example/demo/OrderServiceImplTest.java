package com.example.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.oracle.OrderServiceImpl;
import com.oracle.PaymentService;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        // You can initialize common stubs here if needed
    }

    @Test
    void testPlaceOrder_ValidProduct() {
        // Arrange
        String product = "TShirt";
        int quantity = 2;
        float expectedPrice = 1000.0f * quantity;

        when(paymentService.processPayment(expectedPrice))
                .thenReturn("Payment Successful");

        // Act
        String result = orderService.placeOrder(product, quantity);

        // Assert
        assertEquals("Payment Successful", result);
        verify(paymentService, times(1)).processPayment(expectedPrice);
    }

    @Test
    void testPlaceOrder_InvalidProduct() {
        // Arrange
        String product = "Watch"; // not in map

        // Act
        String result = orderService.placeOrder(product, 1);

        // Assert
        assertEquals("Not a valid product", result);
        verify(paymentService, never()).processPayment(anyFloat());
    }

    @Test
    void testPlaceOrder_AnotherProduct() {
        // Arrange
        String product = "Laptop";
        int quantity = 1;
        float expectedPrice = 50000f;

        when(paymentService.processPayment(expectedPrice))
                .thenReturn("Laptop Payment Done");

        // Act
        String result = orderService.placeOrder(product, quantity);

        // Assert
        assertEquals("Laptop Payment Done", result);
        verify(paymentService, times(1)).processPayment(expectedPrice);
    }
}
