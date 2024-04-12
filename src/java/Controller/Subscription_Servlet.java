package Controller;

import DataAccessLayer.SubscriptionDAO;
import DataAccessLayer.SubscriptionDAOImpl;
import Model.Subscription;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Peace Added this.
 *
 * @author aless
 */
@WebServlet(name = "Subscription_Servlet")
public class Subscription_Servlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the JSP page for displaying surplus food
        request.getRequestDispatcher("/Views/subscriptionPage.jsp").forward(request, response);
    }
    private SubscriptionDAO subscriptionDAO;
    @Override
    public void init() {
        subscriptionDAO = new SubscriptionDAOImpl();
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming you have a session attribute named "userId" where you store the current user's ID
//    HttpSession session = request.getSession();
//    int user_id = (int) session.getAttribute("user_id");

        // Retrieve form data
        String neighborhood = request.getParameter("neighborhood");
        int communicationMethodId = Integer.parseInt(request.getParameter("communicationMethod"));
        String[] foodPreferenceIds = request.getParameterValues("foodPreferences");
        int user_id = 1; // Assuming you have user authentication and already have the user ID

        // Convert foodPreferenceIds to a list of string values
        List<String> foodPreferenceList = Arrays.asList(foodPreferenceIds);

        // Create Subscription object
        Subscription subscription = new Subscription();
        subscription.setNeighbourhood_id(Integer.parseInt(neighborhood));
        subscription.setCommunicationMethod_id(communicationMethodId);
        subscription.setFoodPreferences(foodPreferenceList); // Pass the list of string preferences
        subscription.setUser_id(user_id);

        // Add subscription to database
        subscriptionDAO.addSubscription(subscription);
        
        // Store selected food preferences in session
        HttpSession session = request.getSession();
        session.setAttribute("selectedFoodPreferences", foodPreferenceList);

        // Set success message
        request.setAttribute("successMessage", "Subscription successful!");

        // Forward to the same page with the success message
        request.getRequestDispatcher("/Views/subscriptionPage.jsp").forward(request, response);
}

    
   

    
     @Override
    public String getServletInfo() {
        return " Subscription Servlet";
    }
}
