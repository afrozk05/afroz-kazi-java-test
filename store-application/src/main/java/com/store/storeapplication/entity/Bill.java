package com.store.storeapplication.entity;

public class Bill   {

    private double billAmount;
    private boolean isGroceryItem;

    public boolean isGroceryItem() {
        return isGroceryItem;
    }

    public void setGroceryItem(boolean groceryItem) {
        isGroceryItem = groceryItem;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billAmount=" + billAmount +
                ", isGroceryItem=" + isGroceryItem +
                '}';
    }
}
