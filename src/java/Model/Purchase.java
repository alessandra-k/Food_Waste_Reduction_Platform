package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aless
 */
public class Purchase {

    private int purchase_id;
    private Date date;
    private int user_id;
    private List<Item> purchasedItems;

    public Purchase() {
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Item> getPurchasedItems() {
        return purchasedItems;
    }

    public void addPurchasedItem(Item item) {
        if (purchasedItems == null) {
            purchasedItems = new ArrayList<>();
        }
        purchasedItems.add(item);
    }

}
