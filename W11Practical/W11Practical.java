/**
 * Created by ds221 on 26/11/15.
 */
public class W11Practical {


    public static void main(String [ ] args){
        Bookshop Bookshop1 = new Bookshop();
        Customer Customer1 = new Customer("Barry","KY111AA","br@st-andrews.ac.uk");
        Author Author1 = new Author("John", "KY222AA",123456789);
        Genre Genre1 = new Genre("HowTo");
        Genre Genre2 = new Genre("HowNotTo");
        Item Book1 = new Book(1,"Best Book", 5, 10.00d,Author1, "BestBooks", 100, Genre1, "11/10/2013", "paperback");
        Item Book2 = new Book(2,"Worst Book", 1, 1.00d,Author1, "WorstBooks", 101, Genre2, "11/10/2014", "hardback");
        Item Stationery1 = new Stationery(3,"Bic Pen", 1000, 1.50d, "Pen");

        Bookshop1.addItem(Book1);
        Bookshop1.addItem(Book2);
        Bookshop1.addItem(Stationery1);
        Bookshop1.addCustomer(Customer1);
        Customer1.addToBasket(Book1);
        Customer1.addToBasket(Stationery1);

        //Print value and quantity of Stock
        Bookshop1.printStock();
        Bookshop1.calcStockValue();

        //Print value of basket with and without deliver when basket < £20
        System.out.println(Customer1.calculateBasketSubtotal());
        System.out.println(Customer1.calculateBasketTotal());

        //Print value of basket with and without deliver when basket > £20
        Customer1.addToBasket(Book1);
        System.out.println(Customer1.calculateBasketSubtotal());
        System.out.println(Customer1.calculateBasketTotal());

        Bookshop1.printBooks();
        Bookshop1.printBooks(Genre1);
    }
}
