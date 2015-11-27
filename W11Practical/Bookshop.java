import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by ds221 on 26/11/15.
 */

public class Bookshop {
    private List<Customer> customers = new ArrayList<>();
    private List<Item> items = new ArrayList<>();


    public Bookshop() {
    }
    public Bookshop(Customer customers){
        this.customers.add(customers);
    }

    public List<Customer> getCustomers () {
        return customers;
    }
    public void addCustomer(Customer customers) {
        this.customers.add(customers);
    }

    public List<Item> getItems() {
        return items;
    }
    public void addItem(Item item) {
         items.add(item);
    }

    public void printStock(){
        String name;
        int stock;
        String unit = " units";
        for(Item i : items){
            name = i.getName();
            System.out.print("Item: " + name);
            stock = i.getStockQuantity();
            if (stock == 1)
                unit = " unit";
            System.out.println(" has " + stock + unit + " in stock");
        }
    }

    public void printBooks(){
        for(Item i : items){
            if(i.getType() == "electronic" |i.getType() == "hardback" |i.getType() == "paperback") {
                i.printDetails();
            }
        }
    }

    public void printBooks(Genre genre){
        for(Item i : items){
            if(Objects.equals(i.getType(), "electronic") | Objects.equals(i.getType(), "hardback") | Objects.equals(i.getType(), "paperback")) {
                i.printDetails(genre);
            }
        }
    }

    public double calcStockValue() {
        double totalValue = 0;
        for (Item i : items)
            totalValue = totalValue + (i.getPrice() * i.getStockQuantity());
        //**Test Code** System.out.println("Total value of all stock: £" + totalValue);
        return totalValue;
    }
}

