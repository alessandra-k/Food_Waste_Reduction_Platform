package DataAccessLayer;

import Model.Address;
import java.util.List;

/**
 *
 * @author aless
 */
public interface AddressDAO {

    void addAddress(Address address);

    Address getAddressById(int addressId);

    List<Address> getAllAddresses();

    void updateAddress(int addressId);

    void deleteAddress(int addressId);

}
