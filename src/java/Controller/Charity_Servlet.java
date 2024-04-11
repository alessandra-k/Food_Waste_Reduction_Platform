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
public class Charity_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            switch (action) {
                case "CharityHome" ->
                    request.getRequestDispatcher("/Views/charityPage.jsp").forward(request, response);
                case "Subscription" ->
                    request.getRequestDispatcher("/Views/.jsp").forward(request, response);
                default -> {
                    request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
                }
            }
        } else {

            request.getRequestDispatcher("/Views/login.jsp").forward(request, response);

        }
    }

    @Override
    public String getServletInfo() {
        return "Charity Servlet";
    }// </editor-fold>

}
