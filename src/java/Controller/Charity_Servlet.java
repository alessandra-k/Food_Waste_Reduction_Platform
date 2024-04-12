package Controller;

import BusinessLayer.ClaimBusinessLogic;
import BusinessLayer.InventoryBusinessLogic;
import DataAccessLayer.ItemDAO;
import DataAccessLayer.ItemDAOImpl;
import Model.Claim;
import Model.DonationItems;
import Model.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
        String action = request.getParameter("action");

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            switch (action) {
                case "CharityHome": {
                    request.getRequestDispatcher("/Views/charityPage.jsp").forward(request, response);
                    break;
                }
                case "Subscription": {
                    request.getRequestDispatcher("/Views/.jsp").forward(request, response);
                    break;
                }
                case "Claim": {
                    request.getRequestDispatcher("/Views/charity_claim.jsp").forward(request, response);
                    break;
                }
                default: {
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
    Enumeration<String> parameterNames = request.getParameterNames();
    InventoryBusinessLogic inventoryBusinessLogic = new InventoryBusinessLogic();

    while (parameterNames.hasMoreElements()) {
        String paramName = parameterNames.nextElement();
        if (paramName.startsWith("itemQTD_")) {
            String paramValue = request.getParameter(paramName);
            if (!paramValue.isEmpty()) {
                int itemId = Integer.parseInt(paramName.substring("itemQTD_".length()));
                int quantity = Integer.parseInt(paramValue);
                if (quantity > 0) {
                    inventoryBusinessLogic.updateInventory_ReduceQuantity(itemId, quantity);
                }
            }
        }
    }
    // Redirect or forward back to the purchase.jsp page
    RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/charity_claim.jsp");
    dispatcher.forward(request, response);

}

    @Override
    public String getServletInfo() {
        return "Charity Servlet";
    }// </editor-fold>

}
