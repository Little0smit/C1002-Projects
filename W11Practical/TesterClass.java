import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ds221 on 26/11/15.
 */
public class TesterClass {
    Bookshop Bookshop1 = new Bookshop();
    Customer Customer1 = new Customer("Barry","KY111AA","br@st-andrews.ac.uk");
    Author Author1 = new Author("John", "KY222AA",123456789);
    Genre Genre1 = new Genre("HowTo");
    Item Book1 = new Book(1,"Best Book", 5, 10.00d,Author1, "BestBooks", 100, Genre1, "11/10/2013", "paperback");
    Item Stationery1 = new Stationery(3,"Bic Pen", 1000, 1.50d, "Pen");

    @Test
    public void testBasketWhenUnder20(){

        Bookshop1.addItem(Book1);
        Bookshop1.addItem(Stationery1);
        Bookshop1.addCustomer(Customer1);
        Customer1.addToBasket(Book1);
        Customer1.addToBasket(Stationery1);

        double expected = 11.5;
        double result = Customer1.calculateBasketSubtotal();
        assertTrue(expected == result);
        result = Customer1.calculateBasketTotal();
        expected = 13.5;
        assertTrue(expected == result);
    }

    @Test
    public void testBasketWhenOver20(){
        Bookshop1.addItem(Book1);
        Bookshop1.addItem(Stationery1);
        Bookshop1.addCustomer(Customer1);
        Customer1.addToBasket(Book1);
        Customer1.addToBasket(Book1);
        Customer1.addToBasket(Stationery1);

        double expected = 21.5;
        double result = Customer1.calculateBasketSubtotal();
        assertTrue(expected == result);
        result = Customer1.calculateBasketTotal();
        expected = 21.5;
        assertTrue(expected == result);
    }

    @Test
    public void testAddItemToShop(){
        Bookshop1.addItem(Book1);
        List<Item> Items= Bookshop1.getItems();
        assertTrue(Items.contains(Book1));
        assertFalse(Items.contains(Stationery1));
    }

    @Test
    public void testAddRemoveItemToBasket(){
        Bookshop1.addItem(Book1);
        Bookshop1.addCustomer(Customer1);
        Customer1.addToBasket(Book1);
        List<Item> Items= Customer1.getBasket();
        assertTrue(Items.contains(Book1));
        assertFalse(Items.contains(Stationery1));
        Customer1.removeFromBasket(Book1);
        Items= Customer1.getBasket();
        assertFalse(Items.contains(Book1));
    }

    @Test
    public void testShopTotalValue(){
        Bookshop1.addItem(Book1);
        double expected = 50.0;
        double result = Bookshop1.calcStockValue();
        assertTrue(expected == result);
        Bookshop1.addItem(Stationery1);
        expected = 1550;
        result = Bookshop1.calcStockValue();
        assertTrue(expected == result);
    }

}
