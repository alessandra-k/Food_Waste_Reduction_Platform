
package DataAccessLayer;

/**
 *
 * @author aless
 */
public interface SurplusItemsDAO {
    
    void updateItemDiscount(int itemId, int discountId);
    
    void updateDonationFlag(int itemId, boolean forDonation);
    
}
