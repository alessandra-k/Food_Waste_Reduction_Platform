package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aless
 */
public class Inventory {

    private int inventory_id;
    private int quantity;
    private List<Item> itemsList;

    public Inventory() {
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void addItem(Item item) {
        if (itemsList == null) {
            itemsList = new ArrayList<>();
        }
        itemsList.add(item);
    }

    public List<Item> getSurplusItems() {
        List<Item> surplusItems = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate oneWeekLater = today.plusWeeks(1);

        //TO DO: implementation
        return surplusItems;
    }
}
