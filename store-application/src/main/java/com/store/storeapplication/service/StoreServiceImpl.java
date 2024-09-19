package com.store.storeapplication.service;

import com.store.storeapplication.entity.Bill;
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
    public Double calculateTotalAmount( Bill bill) {
    double totalBillAmount =storeUtil.calculateTotalAmount(bill.getProducts());
    double discount = storeUtil.calculateDiscount(totalBillAmount, bill.getUser(), bill.getProducts());
    return totalBillAmount - discount;
    }
}
