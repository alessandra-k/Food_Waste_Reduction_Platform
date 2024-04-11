package DataAccessLayer;

import Model.DonationItems;
import Model.ExcessDemandItems;
import Model.Inventory;
import Model.Item;
import Model.SalesItems;
import java.util.List;

/**
 *
 * @author aless
 */
public interface InventoryDAO {

    void addToInventory(int itemId, int quantity);

    Inventory getInventoryById(int inventoryId);

    List<Inventory> getAllInventories();

    void updateInventory(int itemId, int quantity);
    
    List<SalesItems> getItemsWithDiscount();
    
    List<DonationItems> getDonationItems();
    
    List<ExcessDemandItems> getItemsWithExcessDemand();
    
    List<Item> getItemsCloseToExpiration();

    void deleteInventory(int inventoryId);

    public void deleteItem_FromIventory(int itemID);

    boolean itemExists(int itemId);
}
