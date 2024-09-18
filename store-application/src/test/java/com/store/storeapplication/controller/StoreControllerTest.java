package com.store.storeapplication.controller;

import com.store.storeapplication.entity.Bill;
import com.store.storeapplication.entity.TotalRequest;
import com.store.storeapplication.entity.User;
import com.store.storeapplication.service.StoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

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
    void testCalculateTotalAmount() {
        ResponseEntity<Double> response ;
        StoreController controller = new StoreController(storeService);
        TotalRequest totalRequest = new TotalRequest();
        User user = new User();
        user.setEmployee(true);
        Bill bill = new Bill();
        bill.setBillAmount(150.75);
        bill.setGroceryItem(true);
        totalRequest.setUser(user);
        totalRequest.setBill(bill);
        when(storeService.calculateTotalAmount(user,bill)).thenReturn(145.75);
        response = controller.calculateTotalAmount(totalRequest);
        assertEquals(145.75, response.getBody());
        assertEquals(200, response.getStatusCode().value());
    }
}
