package items;

import discounts.IDiscountable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShoppingBasket {

    private ArrayList<Item> items;

    public ShoppingBasket(boolean customerHasLoyaltyCard){
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public double getTotalCost(){
        double total = 0;
        for(Item item: this.items){
            total += item.getCost();
        }
        return total;
    }


    public double applyDiscount(ArrayList<IDiscountable> discounts, ArrayList<Item> items, double total){
        double discountedAmount = 0;

        for(IDiscountable discount : discounts){
            discountedAmount += discount.getDiscountedAmount(items, total);
        }

        return total - discountedAmount;
    }

}
