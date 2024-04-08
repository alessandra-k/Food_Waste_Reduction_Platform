package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aless
 */
public class Index_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");

        if ("register".equals(action)) {
            request.getRequestDispatcher("/Views/registration.jsp").forward(request, response);
        } else if ("login".equals(action)) {
            request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
       }    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }


    @Override
    public String getServletInfo() {
        return "Index Servlet";
    }// </editor-fold>

}
