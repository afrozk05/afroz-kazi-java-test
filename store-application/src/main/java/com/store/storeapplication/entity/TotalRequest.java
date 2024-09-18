package com.store.storeapplication.entity;

import jakarta.validation.constraints.NotNull;

public class TotalRequest {
    @NotNull(message = "User cannot be null")
    private User user;
    @NotNull(message = "Bill cannot be null")
    private Bill bill;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "TotalRequest{" +
                "user=" + user +
                ", bill=" + bill +
                '}';
    }
}
