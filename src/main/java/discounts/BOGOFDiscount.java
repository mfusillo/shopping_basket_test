package discounts;

import items.Item;

import java.util.ArrayList;

public class BOGOFDiscount implements IDiscountable {

    public void discount(ArrayList<Item> items){
        for(int i = 0; i < items.size() - 1; i++){
            if(items.get(i) == items.get(i + 1)){
                items.get(i).setCost(0);
            }
        }
    }

}
