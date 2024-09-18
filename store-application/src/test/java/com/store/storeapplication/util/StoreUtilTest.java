package com.store.storeapplication.util;

import com.store.storeapplication.entity.Bill;
import com.store.storeapplication.entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreUtilTest {

    @InjectMocks
    private StoreUtil storeUtil;
    @Test
    void testGetDiscountForUser_GroceryItem(){
        StoreUtil storeUtil=new StoreUtil();
        User user = new User();
        user.setEmployee(true);
        Bill bill = new Bill();
        bill.setBillAmount(150.75);
        bill.setGroceryItem(true);
        Double expectedResult=storeUtil.getDiscountForUser(user,bill);
        assertEquals(0.0,expectedResult);
    }

    @Test
    void testGetDiscountForUser_NonGrocery_Emp(){
        StoreUtil storeUtil=new StoreUtil();
        User user = new User();
        user.setEmployee(true);
        Bill bill = new Bill();
        bill.setBillAmount(150.75);
        bill.setGroceryItem(false);
        Double expectedResult=storeUtil.getDiscountForUser(user,bill);
        assertEquals(45.225,expectedResult);
    }

    @Test
    void testGetDiscountForUser_NonGrocery_Affliate(){
        StoreUtil storeUtil=new StoreUtil();
        User user = new User();
        user.setAffliate(true);
        Bill bill = new Bill();
        bill.setBillAmount(150.75);
        bill.setGroceryItem(false);
        Double expectedResult=storeUtil.getDiscountForUser(user,bill);
        assertEquals(15,Math.floor(expectedResult));
    }

    @Test
    void testGetDiscountForUser_NonGrocery_TwoYrs(){
        StoreUtil storeUtil=new StoreUtil();
        User user = new User();
        user.setAssociationDate(LocalDate.of(2020, 1, 1));
        Bill bill = new Bill();
        bill.setBillAmount(150.75);
        bill.setGroceryItem(false);
        Double expectedResult=storeUtil.getDiscountForUser(user,bill);
        assertEquals(7,Math.floor(expectedResult));
    }

    @Test
    void testCalculateAmountPostDiscount(){
        StoreUtil storeUtil=new StoreUtil();
        Bill bill = new Bill();
        bill.setBillAmount(150.75);
        bill.setGroceryItem(false);
        Double expectedResult=storeUtil.calculateAmountPostDiscount(bill);
        assertEquals(5,Math.floor(expectedResult));
    }
}
