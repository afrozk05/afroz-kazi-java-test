package com.store.storeapplication.controller;

import com.store.storeapplication.entity.Bill;
import com.store.storeapplication.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    @PostMapping
    public ResponseEntity<Double> calculateTotalAmount(@Valid @RequestBody Bill bill) {
        double totalAmount = storeService.calculateTotalAmount(bill);
        return ResponseEntity.ok(totalAmount);
    }
}
