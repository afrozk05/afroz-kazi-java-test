package com.store.storeapplication.service;

import com.store.storeapplication.entity.Bill;
import com.store.storeapplication.entity.User;


public interface StoreService {
     Double calculateTotalAmount(User user, Bill bill);
}

