package discounts;

import items.Item;

import java.util.ArrayList;

public class BOGOFDiscount implements IDiscountable {

    public double getDiscountedAmount(ArrayList<Item> items, double total) {

        double discountedAmount = 0;

        for(int i = 0 ; i < items.size() - 1; i += 2){
            if(items.get(i) == items.get(i + 1)){
                discountedAmount += items.get(i).getCost();
            }
        }

        return discountedAmount;
    }
}
