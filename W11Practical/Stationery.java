/**
 * Created by ds221 on 26/11/15.
 */
public class Stationery extends Item{
    private String type;

    public Stationery(int itemCode, String name, int stockQuantity, double price, String type) {
        super(itemCode, name, stockQuantity, price);
        this.type = type;
    }
    public Stationery() {
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
