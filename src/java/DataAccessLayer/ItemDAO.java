package DataAccessLayer;

import Model.Item;
import java.util.List;

/**
 *
 * @author aless
 */
public interface ItemDAO {

    void addItem(Item item);

    Item getItemById(int itemId);

    List<Item> getAllItems();

    void updateItem(int itemId, boolean forDonation, int discountId);

    void deleteItem(int itemId);
}
