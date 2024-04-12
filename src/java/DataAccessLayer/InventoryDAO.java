package DataAccessLayer;

import Model.DonationItems;
import Model.ExcessDemandItems;
import Model.General_Items_Inventory;
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

   General_Items_Inventory getItemById(int itemId);

    List<Inventory> getAllInventories();

    void updateInventory(int itemId, int quantity);
    void updateInventory_ReduceQuantity(int itemId, int quantity);

    List<SalesItems> getItemsWithDiscount();

    List<DonationItems> getDonationItems();

    List<ExcessDemandItems> getItemsWithExcessDemand();

    List<Item> getItemsCloseToExpiration();

    List<General_Items_Inventory> getItemsAvailableForPurchase();

    void deleteInventory(int inventoryId);

    public void deleteItem_FromIventory(int itemID);

    boolean itemExists(int itemId);
}
