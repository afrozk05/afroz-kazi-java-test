package com.store.storeapplication.util;

import com.store.storeapplication.entity.Product;
import com.store.storeapplication.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Component
public class StoreUtil {

   public double calculateTotalAmount(List<Product> products) {
        return products.stream().mapToDouble(Product::getTotalPrice).sum();
    }

    public  double calculateDiscount(double totalAmount, User user, List<Product> products) {
        double percentageDiscount = getPercentageDiscount(user, products);
        double discountPerHundredDollar = getBulkDiscount(totalAmount);

        return percentageDiscount + discountPerHundredDollar;
    }

    private double getPercentageDiscount(User user, List<Product> products) {
        // Calculate the total for non-grocery items to apply percentage discounts
        double nonGroceryTotal = products.stream()
                .filter(product -> !product.isGroceryItem())
                .mapToDouble(Product::getTotalPrice)
                .sum();

        // No percentage discount if there are no non-grocery items
        if (nonGroceryTotal == 0) {
            return 0;
        }

        double percentage = 0;
        if (user.isEmployee()) {
            percentage = 0.30;
        } else if (user.isAffliate()) {
            percentage = 0.10;
        } else if (user.getAssociationDate()!=null && isUserAssociatedMoreThanTwoYears(user)) {
            percentage = 0.05;
        }

        return nonGroceryTotal * percentage;
    }

    private double getBulkDiscount(double totalAmount) {
        return (totalAmount / 100) * 5;
    }

    private boolean isUserAssociatedMoreThanTwoYears(User user) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(user.getAssociationDate(), now);
        return period.getYears() > 2;
    }

}
