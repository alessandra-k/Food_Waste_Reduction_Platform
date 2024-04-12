package Model;

import java.util.Date;

/**
 *
 * @author aless
 */
public class General_Items_Inventory extends Inventory{

    private int itemId;
    private String name;
    private String description;
    private double price;
    private Date expirationDate;
    private int quantity;
        private String discountDescription;

    public General_Items_Inventory() {
    }

    public General_Items_Inventory(int itemId, String name, String description, double price, Date expirationDate, int quantity, String discountDescription) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.discountDescription = discountDescription;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }
    
    

}
