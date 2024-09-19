package com.store.storeapplication.entity;

import java.time.LocalDate;

public class User {

    private boolean isEmployee;
    private boolean isAffliate;
    private LocalDate associationDate; //Date when user became associated with store

    public User(boolean isEmployee, boolean isAffiliate, LocalDate associationDate) {
        this.isEmployee = isEmployee;
        this.isAffliate = isAffiliate;
        this.associationDate = associationDate;
    }
    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public boolean isAffliate() {
        return isAffliate;
    }

    public void setAffliate(boolean affliate) {
        isAffliate = affliate;
    }

    public LocalDate getAssociationDate() {
        return associationDate;
    }

    public void setAssociationDate(LocalDate associationDate) {
        this.associationDate = associationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "isEmployee=" + isEmployee +
                ", isAffliate=" + isAffliate +
                ", associationDate=" + associationDate +
                '}';
    }
}
