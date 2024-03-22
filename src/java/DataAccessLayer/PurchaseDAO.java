package DataAccessLayer;

import Model.Purchase;
import java.util.List;

/**
 *
 * @author aless
 */
public interface PurchaseDAO {

    void addPurchase(Purchase purchase);

    Purchase getPurchaseById(int purchaseId);

    List<Purchase> getAllPurchases();

    void updatePurchase(int purchaseId);

    void deletePurchase(int purchaseId);
}
