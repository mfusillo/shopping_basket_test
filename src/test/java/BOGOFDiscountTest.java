import discounts.BOGOFDiscount;
import discounts.IDiscountable;
import items.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BOGOFDiscountTest {

    Item item1;
    Item item2;
    Item item3;
    ArrayList<Item> items;
    IDiscountable discount;

    @Before
    public void before(){
        item1 = new Item("Coffee", 1.50);
        item2 = new Item("Bread", 0.50);
        item3 = new Item("Huel", 3.50);
        items = new ArrayList<Item>();
        discount = new BOGOFDiscount();
    }

    @Test
    public void can_apply_bogof_discount(){

    }

}
