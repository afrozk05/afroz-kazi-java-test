package com.store.storeapplication.service;

import com.store.storeapplication.entity.Bill;
import com.store.storeapplication.entity.User;
import com.store.storeapplication.util.StoreUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    void testCalculateTotalAmount(){
        StoreServiceImpl storeServiceImpl = new StoreServiceImpl(storeUtil);
        User user = new User();
        user.setEmployee(true);
        Bill bill = new Bill();
        bill.setBillAmount(150.75);
        bill.setGroceryItem(true);
        when(storeUtil.getDiscountForUser(user, bill)).thenReturn(0.0);
        when( storeUtil.calculateAmountPostDiscount(bill)).thenReturn(5.0);
        Double expectedResult=storeServiceImpl.calculateTotalAmount(user,bill);
        assertEquals(145.75,expectedResult);
    }
}
