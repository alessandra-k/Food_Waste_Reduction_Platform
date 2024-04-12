package Model;

/**
 *
 * @author aless
 */
public class Address {

    private Integer address_id;
    private String street;
    private String postalCode;
   private int user_id; 

    public Address() {
    }

    public Address(String street, String postalCode, Integer user_id) {
        this.street = street;
        this.postalCode = postalCode;
        this.user_id = user_id;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer adress_id) {
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
    
        public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


  
}
