package DataAccessLayer;

import Model.Address;
import Model.User;

/**
 *
 * @author aless
 */
public interface AddressDAO {

    void addAddress(Address address);
    
     void updateAddress(int addressId, User user);

}