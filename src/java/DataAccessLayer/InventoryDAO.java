package DataAccessLayer;

import Model.Inventory;
import java.util.List;

/**
 *
 * @author aless
 */
public interface InventoryDAO {

    void addToInventory(String inventoryType, int subclassId, int itemId, int quantity);

    Inventory getInventoryById(int inventoryId);

    List<Inventory> getAllInventories();

    void updateInventory(int itemId, int quantity);

    void deleteInventory(int inventoryId);
    
        public void deleteItem_FromIventory(int itemID) ;
        
        boolean itemExists(int itemId);
}
