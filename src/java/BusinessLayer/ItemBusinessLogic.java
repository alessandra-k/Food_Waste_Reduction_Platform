package BusinessLayer;

import DataAccessLayer.ItemDAO;
import DataAccessLayer.ItemDAOImpl;
import Model.Item;
import java.util.List;

/**
 * Business logic class for managing items.
 */
public class ItemBusinessLogic {

    private ItemDAO itemDAO;

    public ItemBusinessLogic() {
        itemDAO = new ItemDAOImpl();
    }

    /**
     * Adds a new item.
     * @param item The item to add.
     */
    public void addItem(Item item) {
        itemDAO.addItem(item);
    }

    /**
     * Retrieves an item by its ID.
     * @param itemId The ID of the item to retrieve.
     * @return The item with the specified ID, or null if not found.
     */
    public Item getItemById(int itemId) {
        return itemDAO.getItemById(itemId);
    }

    /**
     * Retrieves all items.
     * @return A list of all items.
     */
    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    
    public void updateItem(int itemId, boolean forDonation, int discountId) {
        itemDAO.updateItem(itemId, forDonation, discountId);
    }

    /**
     * Deletes an item by its ID.
     * @param itemId The ID of the item to delete.
     */
    public void deleteItem(int itemId) {
        itemDAO.deleteItem(itemId);
    }
}
