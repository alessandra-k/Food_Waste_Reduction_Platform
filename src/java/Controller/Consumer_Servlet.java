package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aless
 */
public class Consumer_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            String action = request.getParameter("action");
            switch (action) {
                case "ConsumerHome" ->
                    request.getRequestDispatcher("/Views/consumerPage.jsp").forward(request, response);
                case "Subscription" ->
                    request.getRequestDispatcher("/Views/subscriptionPage.jsp").forward(request, response);
                case "MySubscription" ->
                    request.getRequestDispatcher("/Views/mySubscriptionPage.jsp").forward(request, response);
                default -> {
                    request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
                }
            }
        } else {

            request.getRequestDispatcher("/Views/login.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Consumer Servlet";
    }// </editor-fold>

}
