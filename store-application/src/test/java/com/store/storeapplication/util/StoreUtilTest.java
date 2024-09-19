package com.store.storeapplication.util;

import com.store.storeapplication.entity.Product;
import com.store.storeapplication.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreUtilTest {

    @InjectMocks
    private StoreUtil storeUtil;

    private AutoCloseable autoCloseable;

    @BeforeEach
    public void beforeEach() {
        this.autoCloseable= MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEmployeeDiscount() {
        User user = new User(true, false, LocalDate.of(2023, 9, 19));
        Product product1 = new Product("Laptop",  1, 1000);
        Product product2 = new Product("Phone",  1, 600);
        double netAmount = storeUtil.calculateDiscount(1600,user,Arrays.asList(product1,product2));
        assertEquals(560.0, netAmount);
    }

    @Test
    public void testAffiliateDiscount() {
        User user = new User(false, true,  LocalDate.of(2023, 9, 19));
        Product product = new Product("Laptop",  1, 1000);
        double netAmount = storeUtil.calculateDiscount(1000,user,Arrays.asList(product));
        assertEquals(150.0, netAmount);
    }

    @Test
    public void testAssociatedCustomerDiscount() {
        User user = new User(false, false, LocalDate.of(2020, 9, 19));
        Product product = new Product("Laptop",  1, 1000);
        double netAmount = storeUtil.calculateDiscount(1000,user,Arrays.asList(product));
        assertEquals(100.0, netAmount);
    }

    @Test
    public void testBulkDiscount() {
        User user = new User(false, false,  LocalDate.of(2023, 9, 19));
        Product product = new Product("cheese",  1, 200);
        double netAmount = storeUtil.calculateDiscount(200,user,Arrays.asList(product));
        assertEquals(10.0, netAmount);
    }

    @Test
    public void testMixAndBulkDiscount() {
        User user = new User(true, false,  LocalDate.of(2023, 9, 19));
        Product product1 = new Product("Laptop",  1, 1000);
        Product product2 = new Product("cheese",  1, 200);
        double netAmount = storeUtil.calculateDiscount(1200,user,Arrays.asList(product1,product2));
        assertEquals(360.0, netAmount);
    }
}
