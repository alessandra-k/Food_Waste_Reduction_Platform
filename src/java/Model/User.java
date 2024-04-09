package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aless
 */
public class User {

    private Integer user_id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private int userType_id;
     private Integer address_id; 
    private String phone;
    private List<Subscription> subscriptions;

    public User(UserBuilder builder) {
        userName = builder.getUserName();
        userEmail = builder.getUserEmail();
        userPassword = builder.getUserPassword();
        userType_id = builder.getUserType_id();
        address_id = builder.getAddressId();
        phone = builder.getPhone();
        subscriptions = builder.getSubscriptions();
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserType_id() {
        return userType_id;
    }

    public void setUserType_id(int userType_id) {
        this.userType_id = userType_id;
    }
    
        public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
        public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(Subscription subscription) {
        if (subscriptions == null) {
            subscriptions = new ArrayList<>();
        }
        subscriptions.add(subscription);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(userName).append(" ")
                .append(userEmail).append(" ")
                .append(userPassword).append(" ")
                .append(userType_id).append(" ")
                .append(address_id).append(" ")
                .append(phone);
        return sb.toString();

    }

}
