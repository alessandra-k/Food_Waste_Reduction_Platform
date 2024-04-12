package BusinessLayer;

import DataAccessLayer.InventoryDAO;
import DataAccessLayer.InventoryDAOImpl;
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
public class InventoryBusinessLogic {

    private InventoryDAO inventoryDAO = null;

    public InventoryBusinessLogic() {
        inventoryDAO = new InventoryDAOImpl();
    }

    public void addToInventory(int itemId, int quantity) {
        inventoryDAO.addToInventory(itemId, quantity);
    }
    
    public void updateInventory_ReduceQuantity(int itemId, int quantity) {
        inventoryDAO.updateInventory_ReduceQuantity(itemId, quantity);
    }

    public List<SalesItems> getItemsWithDiscount() {
        return inventoryDAO.getItemsWithDiscount();
    }

    public List<DonationItems> getDonationItems() {
        return inventoryDAO.getDonationItems();
    }

    public List<ExcessDemandItems> getItemsWithExcessDemand() {
        return inventoryDAO.getItemsWithExcessDemand();

    }
    
    public List<Item> getItemsCloseToExpiration(){
        return inventoryDAO.getItemsCloseToExpiration();
    }

    public General_Items_Inventory getItemById(int itemId) {
        return inventoryDAO.getItemById(itemId);
    }

    public List<Inventory> getAllInventories() {
        return inventoryDAO.getAllInventories();
    }
    
    public List<General_Items_Inventory> getItemsAvailableForPurchase() {
        return inventoryDAO.getItemsAvailableForPurchase();
    }

    public void updateInventory(int itemId, int quantity) {
        inventoryDAO.updateInventory(itemId, quantity);
    }

    public void deleteInventory(int inventoryId) {
        inventoryDAO.deleteInventory(inventoryId);
    }

    public void deleteItem_FromIventory(int itemID) {
        inventoryDAO.deleteItem_FromIventory(itemID);
    }

    public boolean itemExists(int itemId) {
        return inventoryDAO.itemExists(itemId);
    }
}
