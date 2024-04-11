package BusinessLayer;

import DataAccessLayer.InventoryDAO;
import DataAccessLayer.InventoryDAOImpl;
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
public class InventoryBusinessLogic {

    private InventoryDAO inventoryDAO = null;

    public InventoryBusinessLogic() {
        inventoryDAO = new InventoryDAOImpl();
    }

    public void addToInventory(int itemId, int quantity) {
        inventoryDAO.addToInventory(itemId, quantity);
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

    public Inventory getInventoryById(int inventoryId) {
        return inventoryDAO.getInventoryById(inventoryId);
    }

    public List<Inventory> getAllInventories() {
        return inventoryDAO.getAllInventories();
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
