package com.store.storeapplication.service;

import com.store.storeapplication.entity.Bill;
import com.store.storeapplication.entity.Product;
import com.store.storeapplication.entity.User;
import com.store.storeapplication.util.StoreUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StoreServiceImplTest {
    @InjectMocks
    private StoreServiceImpl storeService;

    @Mock
    private StoreUtil storeUtil;

    private AutoCloseable autoCloseable;

    @BeforeEach
    public void beforeEach() {
        this.autoCloseable= MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateTotalAmountForMixItem(){
        User user = new User(101);
        Product groceryItem = new Product("banana",  2, 10);
        Product nonGroceryItem = new Product("Laptop",  1, 1000);
        Bill bill = new Bill(Arrays.asList(groceryItem, nonGroceryItem), user);
        when(storeUtil.calculateTotalAmount(bill.getProducts())).thenReturn(1100.0);
        when(storeUtil.calculateDiscount(1100, bill.getUser(), bill.getProducts())).thenReturn(355.0);
        Double expectedResult=storeService.calculateTotalAmount(bill);
        assertEquals(745,expectedResult);
    }
}
