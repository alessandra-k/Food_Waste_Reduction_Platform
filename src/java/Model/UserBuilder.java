package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aless
 */
public class UserBuilder {

    private Integer user_id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private int userType_id;
    private Integer address_id;
    private String phone;
    private List<Subscription> subscriptions;

    /*
     * Constructor was marked private to enforce use of create() method
     */
    private UserBuilder() {
      
    }

    /*
     * Returns an instance of this UserBuilder
     */
    public static UserBuilder create() {
        return new UserBuilder();
    }

    public UserBuilder userName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder userEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public UserBuilder userPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public UserBuilder userType_id(int userType_id) {
        this.userType_id = userType_id;
        return this;
    }
    
        public UserBuilder addressId(Integer address_id) { 
        this.address_id = address_id;
        return this;
    }

    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder addSubscription(Subscription subscription) {
        if (subscriptions == null) {
            subscriptions = new ArrayList<>();
        }
        subscriptions.add(subscription);
        return this;
    }

    //Uses the User(UserBuilder) constructor to create and initialize a User
    public User build() {
        return new User(this);
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getUserType_id() {
        return userType_id;
    }
    
        public Integer getAddressId() { 
        return address_id;
    }

    public String getPhone() {
        return phone;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

}
