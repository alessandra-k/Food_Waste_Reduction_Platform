package Controller;

import BusinessLayer.SurplusItemsBusinessLogic;
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
public class SurplusItems_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            switch (action) {
                case "RetailerHome" ->
                    request.getRequestDispatcher("/Views/retailerPage.jsp").forward(request, response);
                case "InventoryManagement" ->
                    request.getRequestDispatcher("/Views/retailer_InventoryManagement.jsp").forward(request, response);
                case "ExcessDemandItems" ->
                    request.getRequestDispatcher("/Views/SurplusItems_Management.jsp").forward(request, response);
                case "ExpiringItems" ->
                    request.getRequestDispatcher("/Views/ExpiringItems_Management.jsp").forward(request, response);
                case "Sales" ->
                    request.getRequestDispatcher("/Views/SalesItems_Management.jsp").forward(request, response);
                case "Donation" ->
                    request.getRequestDispatcher("/Views/Donation_Management.jsp").forward(request, response);

                default -> {
                }
            }
        } else {

            request.getRequestDispatcher("/Views/login.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String button = request.getParameter("button");
        SurplusItemsBusinessLogic surplusBusinessLogic = new SurplusItemsBusinessLogic();

        if ("updateSaleItem".equals(button)) {
            int itemId = Integer.parseInt(request.getParameter("itemID"));
            int discountId = Integer.parseInt(request.getParameter("discount"));

            surplusBusinessLogic.updateItemDiscount(itemId, discountId);
            request.getRequestDispatcher("/Views/SalesItems_Management.jsp").forward(request, response);
        } else if ("updateDonationFlag".equals(button)) {
            int itemId = Integer.parseInt(request.getParameter("itemID"));
            boolean forDonation = request.getParameter("donation") != null;

            surplusBusinessLogic.updateDonationFlag(itemId, forDonation);
            request.getRequestDispatcher("/Views/Donation_Management.jsp").forward(request, response);

        } else if ("setDiscountExpiring".equals(button)) {
            int itemId = Integer.parseInt(request.getParameter("itemID"));
            int discountId = Integer.parseInt(request.getParameter("discount"));

            surplusBusinessLogic.updateItemDiscount(itemId, discountId);

            // Forward the request to the JSP page
            request.getRequestDispatcher("/Views/ExpiringItems_Management.jsp").forward(request, response);

        }
    }

    @Override
    public String getServletInfo() {
        return "SurplusItems Servlet";
    }// </editor-fold>

}
