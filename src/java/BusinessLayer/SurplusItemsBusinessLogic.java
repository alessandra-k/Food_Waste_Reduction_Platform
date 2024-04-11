
package BusinessLayer;

import DataAccessLayer.SurplusItemsDAO;
import DataAccessLayer.SurplusItemsDAOImpl;

/**
 *
 * @author aless
 */
public class SurplusItemsBusinessLogic {
    
    private SurplusItemsDAO surplusItemsDAO;

    public SurplusItemsBusinessLogic() {
        surplusItemsDAO = new SurplusItemsDAOImpl();
    }
            
     public void updateItemDiscount(int itemId, int discountId) {
        surplusItemsDAO.updateItemDiscount(itemId, discountId);
    }
    
    public void updateDonationFlag(int itemId,boolean forDonation) {
        surplusItemsDAO.updateDonationFlag(itemId, forDonation);
    }
    
}
