package discounts;

import items.Item;

import java.util.ArrayList;

public interface IDiscountable {

    double getDiscountedAmount(ArrayList<Item> items, double total);

}
