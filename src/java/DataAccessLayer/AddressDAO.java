package DataAccessLayer;

import Model.Address;
import Model.User;
import java.util.List;

/**
 *
 * @author aless
 */
public interface AddressDAO {

    void addAddress(Address address);

    Address getAddressById(int addressId);

    List<Address> getAllAddresses();

    void updateAddress(int addressId, User user);

    void deleteAddress(int addressId);

}