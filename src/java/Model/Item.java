package Model;

import java.util.Date;

/**
 *
 * @author aless
 */
public class Item {

    private int item_id;
    private String name;
    private String description;
    private double price;
    private Date expirationDate;
    private boolean forDonation;
    private int discount_id;

    public Item() {
    }

    public Item(int item_id, String name, String description, double price, Date expirationDate) {
        this.item_id = item_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
    }   
    
    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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

    public boolean isForDonation() {
        return forDonation;
    }

    public void setForDonation(boolean forDonation) {
        this.forDonation = forDonation;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }
}
