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

    void updateItem(Item item);

    void deleteItem(int itemId);
}
