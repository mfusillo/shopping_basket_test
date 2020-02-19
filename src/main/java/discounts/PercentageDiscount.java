package discounts;

import items.Item;

import java.util.ArrayList;

public class PercentageDiscount implements IDiscountable {
    public double getDiscountedAmount(ArrayList<Item> items, double total){
        double discountedAmount = 0;
        if(total > 20.0){
            discountedAmount += total * 0.1;
        }
        return discountedAmount;
    }
}
