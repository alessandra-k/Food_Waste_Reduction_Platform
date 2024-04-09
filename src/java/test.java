
import BusinessLayer.AddressBusinessLogic;
import BusinessLayer.UserBusinessLogic;
import Model.Address;
import Model.User;
import Model.UserBuilder;
import Model.UserType;

/**
 *
 * @author aless
 */
public class test {

    public static void main(String[] args) {

        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        
          String email = "alessandraprunzelk@gmail.com";
        String password = "1010";

    
        User user = userBusinessLogic.authenticateUser(email, password);
        System.out.println(user);
//        AddressBusinessLogic addressBusinessLogic = new AddressBusinessLogic();
//
//        String name = "name";
//        String street = "address";
//        String postalCode = "postalCode";
//        String phone = "phone";
//        String email = "email";
//        String password = "password";
//        String userTypeString = "RETAILER"; // Match the enum values
//
//        // Convert userTypeString to UserType enum
//        UserType userType = UserType.valueOf(userTypeString);
//
//        // Create Address object
//        Address address = new Address();
//        address.setStreet(street);
//        address.setPostalCode(postalCode);
//
//        // Call business layer to add the address to the database
//        addressBusinessLogic.addAddress(address);
//
//        // Create User object using UserBuilder
//        User user = UserBuilder.create()
//                .userName(name)
//                .userEmail(email)
//                .userPassword(password)
//                .phone(phone)
//                .userType_id(userType.getId())
//                .addressId(address.getAddress_id())
//                .build();
//
//        // Call business layer to add the user to the database
//        userBusinessLogic.addUser(user);
//        addressBusinessLogic.updateAddress(address.getAddress_id(), user);
//    }

}}
