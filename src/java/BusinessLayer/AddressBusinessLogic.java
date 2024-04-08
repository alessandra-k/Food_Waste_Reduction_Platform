package BusinessLayer;

import DataAccessLayer.AddressDAO;
import DataAccessLayer.AddressDAOImpl;
import Model.Address;

/**
 *
 * @author aless
 */
public class AddressBusinessLogic {

    private AddressDAO addressDAO = null;

    public AddressBusinessLogic() {
        addressDAO = new AddressDAOImpl();
    }
    
    public void addAddress(Address address) {
        addressDAO.addAddress(address);
    }
    
    

}
