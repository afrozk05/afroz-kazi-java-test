package com.store.storeapplication.entity;

import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

public class Product {
    @NotNull(message = "productName cannot be null")
    private String productName;
    private boolean isGroceryItem;
    @NotNull(message = "quantity cannot be null")
    private int quantity;
    @NotNull(message = "price cannot be null")
    private double price;

    private static final List<String> GROCERY_ITEMS = Arrays.asList(
            "apple", "banana", "orange", "milk", "bread", "eggs", "cheese", "rice", "pasta"
    );

    public Product(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.isGroceryItem = determineIfGroceryItem(productName);
    }

    public String getProductName() {
        return productName;
    }

    public boolean isGroceryItem() {
        return isGroceryItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    private boolean determineIfGroceryItem(String productName) {
        return GROCERY_ITEMS.contains(productName.toLowerCase());
    }
}
