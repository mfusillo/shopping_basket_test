import discounts.BOGOFDiscount;
import discounts.IDiscountable;
import discounts.PercentageDiscount;
import items.Item;
import items.ShoppingBasket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    Item item1;
    Item item2;
    Item item3;
    ShoppingBasket shoppingBasket;
    IDiscountable discount1;
    IDiscountable discount2;
    ArrayList<IDiscountable> discounts;

    @Before
    public void before(){
        item1 = new Item("Coffee", 1.50);
        item2 = new Item("Bread", 0.50);
        item3 = new Item("Huel", 10.0);
        shoppingBasket = new ShoppingBasket(true);
        discount1 = new PercentageDiscount();
        discount2 = new BOGOFDiscount();
        discounts = new ArrayList<IDiscountable>();
    }

    @Test
    public void can_get_percentage_discounted_amount(){
        discounts.add(discount1);
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item3);
        assertEquals(27.0, shoppingBasket.applyDiscount(discounts, shoppingBasket.getItems(), shoppingBasket.getTotalCost()), 0.001);
    }

    @Test
    public void cannot_get_percentage_discounted_amount(){
        discounts.add(discount1);
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item3);
        assertEquals(20.0, shoppingBasket.applyDiscount(discounts, shoppingBasket.getItems(), shoppingBasket.getTotalCost()), 0.001);
    }

    @Test
    public void can_apply_bogof_discount(){
        discounts.add(discount2);
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item1);
        shoppingBasket.getItems().add(item2);
        assertEquals(12, shoppingBasket.applyDiscount(discounts, shoppingBasket.getItems(), shoppingBasket.getTotalCost()), 0.001);
    }

    @Test
    public void cannot_apply_bogof_discount(){
        discounts.add(discount2);
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item1);
        assertEquals(11.50, shoppingBasket.applyDiscount(discounts, shoppingBasket.getItems(), shoppingBasket.getTotalCost()), 0.001);
    }

    @Test
    public void can_apply_all_discounts(){
        discounts.add(discount1);
        discounts.add(discount2);
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item3);
        assertEquals(17.0, shoppingBasket.applyDiscount(discounts, shoppingBasket.getItems(), shoppingBasket.getTotalCost()), 0.001);

    }


}
