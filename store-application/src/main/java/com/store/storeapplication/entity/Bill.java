package com.store.storeapplication.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Bill   {

    @NotEmpty
    private List<Product> products;
    @NotNull(message="User information cannot be null.")
    private User user;

    public Bill(List<Product> products, User user) {
        this.products = products;
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }
}
