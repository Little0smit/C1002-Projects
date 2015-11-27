import java.util.ArrayList;
import java.util.List;

/**
 * Created by ds221 on 26/11/15.
 */
public class Customer {
    private final List<Item> basket = new ArrayList<>();
    private String name;
    private String address;
    private String email;

    public Customer(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }
    public Customer() {
    }

    public List<Item> getBasket() {
        return basket;
    }
    public void addToBasket(Item item){
        basket.add(item);
    }
    public void removeFromBasket(Item item){
        basket.remove(item);
        System.out.println("The following item has been removed from the basket: " + item.getName());
    }
    public double calculateBasketSubtotal(){
        double basketTotal = 0;
        for(Item i: basket){
            basketTotal = basketTotal + i.getPrice();
        }
        //**Test Code** System.out.println("Basket subtotal: £" + basketTotal);
        return basketTotal;
    }
    public double calculateBasketTotal() {
        double basketTotal = calculateBasketSubtotal();
        if (basketTotal > 20d)
            return basketTotal;
        for (Item i : basket) {
            if (i.getType() != "electronic") {
                basketTotal = basketTotal + 1;
            }
        }
        return basketTotal;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
