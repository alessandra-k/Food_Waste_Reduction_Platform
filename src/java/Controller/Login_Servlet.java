package Controller;

import BusinessLayer.UserBusinessLogic;
import Model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aless
 */
@WebServlet(name = "Login_Servlet", urlPatterns = {"/Login_Servlet"})
public class Login_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    // Authenticate user
    UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
    User user = userBusinessLogic.authenticateUser(email, password);

    if (user != null) {
        // User authenticated successfully, create HttpSession
        HttpSession session = request.getSession();
        
        // Store user information in the session
        session.setAttribute("user", user);
        
        // Set the maximum age of the session to 10 seconds
        session.setMaxInactiveInterval(5);

        // Create a Cookie to store the user's email
        Cookie emailCookie = new Cookie("userEmail", email);
        emailCookie.setMaxAge(5); 
        response.addCookie(emailCookie);

        // Determine the user type and redirect accordingly
        switch (user.getUserType_id()) {
            case 1:
                 request.getRequestDispatcher("/Views/retailerPage.jsp").forward(request, response);
                break;
            case 2:
                 request.getRequestDispatcher("/Views/consumerPage.jsp").forward(request, response);
                break;
            case 3:
                 request.getRequestDispatcher("/Views/charityPage.jsp").forward(request, response);
                break;
        }
    } else {
        request.setAttribute("error", "Email or password incorrect");
        request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
    }
}


    @Override
    public String getServletInfo() {
        return "Login Servlet";
    }

}
