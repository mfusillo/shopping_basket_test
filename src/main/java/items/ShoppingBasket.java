package items;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShoppingBasket {

    private ArrayList<Item> items;

    public ShoppingBasket(){
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

}
