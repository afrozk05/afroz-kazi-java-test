package com.store.storeapplication.util;

import com.store.storeapplication.entity.Bill;
import com.store.storeapplication.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
@Component
public class StoreUtil {

    public Double getDiscountForUser(User user,Bill bill){
        if (bill.isGroceryItem()) {
            return 0.0; //no discount for grocery
        }

        double discount = 0.0;
        if (user.isEmployee()) {
            discount = 0.30 * bill.getBillAmount();
        } else if (user.isAffliate()) {
            discount = 0.10 * bill.getBillAmount();
        } else if (user.getAssociationDate()!=null && isUserAssociatedMoreThanTwoYears(user)) {
            discount = 0.05 * bill.getBillAmount();
        }

        return discount;
    }

    public Double calculateAmountPostDiscount(Bill bill){
        return Math.floor(bill.getBillAmount() / 100) * 5;
    }

    private boolean isUserAssociatedMoreThanTwoYears(User user) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(user.getAssociationDate(), now);
        return period.getYears() > 2;
    }

}
