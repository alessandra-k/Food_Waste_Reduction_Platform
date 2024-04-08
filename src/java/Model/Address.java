package Model;

/**
 *
 * @author aless
 */
public class Address {

    private int address_id;
    private String street;
    private String postalCode;
    private User user; // Assuming each address belongs to one user

    public Address() {
    }

    public Address(String street, String postalCode, User user) {
        this.street = street;
        this.postalCode = postalCode;
        this.user = user;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int adress_id) {
        this.address_id = adress_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


  
}
