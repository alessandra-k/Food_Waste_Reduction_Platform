package Controller;

import BusinessLayer.AddressBusinessLogic;
import BusinessLayer.UserBusinessLogic;
import Model.Address;
import Model.User;
import Model.UserBuilder;
import Model.UserType;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aless
 */
public class Registration_Servlet extends HttpServlet {

    private final UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
    private final AddressBusinessLogic addressBusinessLogic = new AddressBusinessLogic();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       String name = request.getParameter("name");
        String street = request.getParameter("address");
        String postalCode = request.getParameter("postalCode");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userTypeString = request.getParameter("user-type");

        // Convert user type string to UserType enum
        UserType userType = null;
        if ("retailer".equals(userTypeString)) {
            userType = UserType.RETAILER;
        } else if ("consumer".equals(userTypeString)) {
            userType = UserType.CONSUMER;
        } else if ("charitable".equals(userTypeString)) {
            userType = UserType.CHARITY;
        }

        // Create User and Address objects
        Address address = new Address();
        address.setStreet(street);
        address.setPostalCode(postalCode);

        User user = UserBuilder.create()
                .userName(name)
                .userEmail(email)
                .userPassword(password)
                .userType_id(userType.getId())
                .address(address)
                .phone(phone)
                .build();

        try {
            // Call business logic layer to add user and address
            userBusinessLogic.addUser(user);
            addressBusinessLogic.addAddress(address);

         
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            
  
        }}

@Override
public String getServletInfo() {
        return "Registration Servlet";
    }// </editor-fold>

}
