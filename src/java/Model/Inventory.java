package Model;

/**
 *
 * @author aless
 */
public class Inventory {

  private int inventory_id;
    private int item_id;
    private int quantity;

    public Inventory() {
        // Default constructor
    }

    // Getters and setters
    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}