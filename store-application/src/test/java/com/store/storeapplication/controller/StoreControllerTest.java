package com.store.storeapplication.controller;

import com.store.storeapplication.entity.Bill;
import com.store.storeapplication.entity.Product;
import com.store.storeapplication.entity.User;
import com.store.storeapplication.service.StoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StoreControllerTest {
    @InjectMocks
    StoreController storeController;

    @Mock
    StoreService storeService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    public void beforeEach() {
        this.autoCloseable= MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCalculateTotalAmountWithMixItems() {
        ResponseEntity<Double> response ;
        User user = new User(101);
        Product groceryItem = new Product("apple",  2, 50);
        Product nonGroceryItem = new Product("Laptop",  1, 1000);
        Bill bill = new Bill(Arrays.asList(groceryItem, nonGroceryItem), user);
        when(storeService.calculateTotalAmount(bill)).thenReturn(745.0);
        response = storeController.calculateTotalAmount(bill);
        assertEquals(745.0, response.getBody());
        assertEquals(200, response.getStatusCode().value());
    }
}
