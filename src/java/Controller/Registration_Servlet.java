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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Parse user input from request parameters
        String name = request.getParameter("name");
        String street = request.getParameter("address");
        String postalCode = request.getParameter("postalCode");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userTypeString = request.getParameter("user-type");

        // Convert userTypeString to UserType enum
        UserType userType = UserType.valueOf(userTypeString);

        // Create Address object
        Address address = new Address();
        address.setStreet(street);
        address.setPostalCode(postalCode);

        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        AddressBusinessLogic addressBusinessLogic = new AddressBusinessLogic();

        // Call business layer to add the address to the database
        addressBusinessLogic.addAddress(address);

        // Create User object using UserBuilder
        User user = UserBuilder.create()
                .userName(name)
                .userEmail(email)
                .userPassword(password)
                .phone(phone)
                .userType_id(userType.getId())
                .addressId(address.getAddress_id())
                .build();

        // Call business layer to add the user to the database
        userBusinessLogic.addUser(user);
        addressBusinessLogic.updateAddress(address.getAddress_id(), user);

        // Redirect user to a success page or do other operations as needed
        request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Registration Servlet";
    }// </editor-fold>

}
