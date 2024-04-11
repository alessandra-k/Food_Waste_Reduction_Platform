package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aless
 */
public class Inventory {

   private int inventory_id;
    private Map<Item, Integer> itemQuantity;

    public Inventory() {
        this.itemQuantity = new HashMap<>();
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Map<Item, Integer> getItemQuantityMap() {
        return itemQuantity;
    }

    public void addItem(Item item, int quantity) {
        itemQuantity.put(item, quantity);
    }

    public void updateItemQuantity(Item item, int newQuantity) {
        if (itemQuantity.containsKey(item)) {
            itemQuantity.put(item, newQuantity);
        }
    }

    public void removeItem(Item item) {
        itemQuantity.remove(item);
    }
}