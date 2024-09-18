package com.store.storeapplication.controller;

import com.store.storeapplication.entity.TotalRequest;
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
    public ResponseEntity<Double> calculateTotalAmount(@Valid @RequestBody TotalRequest totalRequest) {
        double totalAmount = storeService.calculateTotalAmount(totalRequest.getUser(),totalRequest.getBill());
        return ResponseEntity.ok(totalAmount);
    }
}
