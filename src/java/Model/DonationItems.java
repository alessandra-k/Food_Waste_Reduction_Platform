
package Model;

import java.util.Date;

/**
 *
 * @author aless
 */
public class DonationItems {
    
    
    private int itemId;
    private String name;
    private String description;
    private double price;
    private Date expirationDate;
    private int quantity;
    private Boolean isForDonation;

    public DonationItems() {
    }

    public DonationItems(int itemId, String name, String description, double price, Date expirationDate, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getIsForDonation() {
        return isForDonation;
    }

    public void setIsForDonation(Boolean isForDonation) {
        this.isForDonation = isForDonation;
    }
    
    

}