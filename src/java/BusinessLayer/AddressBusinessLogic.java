package BusinessLayer;

import DataAccessLayer.AddressDAO;
import DataAccessLayer.AddressDAOImpl;
import Model.Address;
import Model.User;

/**
 * Making changes to see if it is working
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
    
        public void updateAddress(int addressId, User user) {
            addressDAO.updateAddress(addressId, user);
        }
    
    
    
    
    

}
