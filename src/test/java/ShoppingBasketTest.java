import discounts.IDiscountable;
import discounts.PercentageDiscount;
import items.Item;
import items.ShoppingBasket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    Item item1;
    Item item2;
    Item item3;
    ShoppingBasket shoppingBasket;
    IDiscountable discount;

    @Before
    public void before(){
        item1 = new Item("Coffee", 1.50);
        item2 = new Item("Bread", 0.50);
        item3 = new Item("Huel", 10.0);
        shoppingBasket = new ShoppingBasket();
        discount = new PercentageDiscount();
    }

    @Test
    public void can_get_percentage_discounted_amount(){
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item3);
        assertEquals(3.0, discount.getDiscountedAmount(shoppingBasket.getItems(), shoppingBasket.getTotalCost()), 0.001);
    }

    @Test
    public void cannot_get_percentage_discounted_amount(){
        shoppingBasket.getItems().add(item3);
        shoppingBasket.getItems().add(item3);
        assertEquals(0.0, discount.getDiscountedAmount(shoppingBasket.getItems(), shoppingBasket.getTotalCost()), 0.001);
    }


}
