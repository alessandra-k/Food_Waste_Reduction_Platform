package DataAccessLayer;

import Model.Inventory;
import java.util.List;

/**
 *
 * @author aless
 */
public interface InventoryDAO {

    void addInventory(Inventory inventory);

    Inventory getInventoryById(int inventoryId);

    List<Inventory> getAllInventories();

    void updateInventory(int inventoryId);

    void deleteInventory(int inventoryId);
}
