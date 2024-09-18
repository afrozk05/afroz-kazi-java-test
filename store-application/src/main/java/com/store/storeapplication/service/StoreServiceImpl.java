package com.store.storeapplication.service;

import com.store.storeapplication.entity.Bill;
import com.store.storeapplication.entity.User;
import com.store.storeapplication.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

private final StoreUtil storeUtil;
    @Autowired
    public StoreServiceImpl(StoreUtil storeUtil) {
        this.storeUtil = storeUtil;
    }

@Override
    public Double calculateTotalAmount(User user, Bill bill) {
        double discountForUser = storeUtil.getDiscountForUser(user, bill);//percentage discount
        double discountOnHundredDollar = storeUtil.calculateAmountPostDiscount(bill);//additional disc on every $100
        double totalDiscount = discountForUser + discountOnHundredDollar;

        return bill.getBillAmount() - totalDiscount;
    }
}
