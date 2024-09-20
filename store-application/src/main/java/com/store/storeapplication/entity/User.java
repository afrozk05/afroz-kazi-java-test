package com.store.storeapplication.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

public class User {

    private static final List<Integer> EMPLOYEE_LIST = Arrays.asList(101, 103, 105, 107, 109, 111);
    private static final List<Integer> AFFLIATE_LIST = Arrays.asList(102, 104, 108, 110, 112, 114);
    private static final List<Integer> ASSOCIATED_CUST_LIST = Arrays.asList(115, 116, 117, 118, 119, 120);

    @NotNull(message = "UserId cannot be null")
    private Integer userId;
    private boolean isEmployee;
    private boolean isAffliate;
    private boolean isLoyalCustomer;

    @JsonCreator
    public User(@JsonProperty("userId") Integer userId) {
        this.userId = userId;
        this.isEmployee = determineIfEmployee(userId);
        this.isAffliate = determineIfAffliate(userId);
        this.isLoyalCustomer = determineAssociatedCustomer(userId);
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public boolean isAffliate() {
        return isAffliate;
    }

    public boolean isLoyalCustomer() {
        return isLoyalCustomer;
    }

    private boolean determineAssociatedCustomer(int userId) {
        return ASSOCIATED_CUST_LIST.contains(userId);
    }

    private boolean determineIfAffliate(int userId) {
        return AFFLIATE_LIST.contains(userId);
    }

    private boolean determineIfEmployee(int userId) {
        return EMPLOYEE_LIST.contains(userId);
    }
}
