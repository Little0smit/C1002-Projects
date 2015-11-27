/**
 * Created by ds221 on 26/11/15.
 */
public class Item {
    private int itemCode;
    private String name;
    private int stockQuantity;
    private double price;
    private String type;

    public Item() {
    }
    public Item(int itemCode, String name, int stockQuantity, double price) {
        this.itemCode = itemCode;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public int getItemCode() {
        return itemCode;
    }
    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }
    public void printDetails() {}
    public void printDetails(Genre genre) {}
}
