package Controller;

import BusinessLayer.InventoryBusinessLogic;
import BusinessLayer.SurplusItemsBusinessLogic;
import Model.ExcessDemandItems;
import ObserverPattern.SurplusFoodSubject;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.pdfbox.pdmodel.font.PDType0Font;


/**
 *
 * @author aless
 */
public class SurplusItems_Servlet extends HttpServlet {
    //Added this By Peace
    private SurplusFoodSubject subject = new SurplusFoodSubject();

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
                case "downloadPDF" -> generateSurplusFoodPDF(response);

                default -> {
                    request.getRequestDispatcher("/Views/login.jsp").forward(request, response);                }
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

        }else if ("listSurplusFoodItem".equals(button)) { // Add this condition to handle listing surplus food items
            // Retrieve the surplus food items details from the request
            String itemName = request.getParameter("itemName");
            double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));

            // Add the new surplus food item to the subject
            subject.addSurplusFoodItem(itemName, itemPrice);

            // Redirect back to the page where the surplus food items were listed
            response.sendRedirect(request.getHeader("referer"));
        }
    }
    //Peace made changes here
    
    private void generateSurplusFoodPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"surplus_food_list.pdf\"");

        try (OutputStream out = response.getOutputStream()) {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                InputStream fontStream = getClass().getResourceAsStream("/arial.ttf");
                PDType0Font font = PDType0Font.load(document, fontStream);
                contentStream.setFont(font, 12);

                contentStream.beginText();
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Surplus Food List");
                contentStream.endText();

                // Fetch surplus food items from your data source (database, etc.)
                InventoryBusinessLogic inventoryLogic = new InventoryBusinessLogic();
                List<ExcessDemandItems> excessDemandItems = inventoryLogic.getItemsWithExcessDemand();

                int y = 680; // Initial Y coordinate (slightly lower to accommodate table headers)

                for (ExcessDemandItems item : excessDemandItems) {
                    y -= 20; // Move to the next line
                    contentStream.beginText();
                    contentStream.newLineAtOffset(100, y);
                    contentStream.showText("Name: " + item.getName());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText("Description: " + item.getDescription());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText("Price: $" + item.getPrice());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText("Expiration Date: " + item.getExpirationDate());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText("Quantity: " + item.getQuantity());
                    contentStream.endText();
                }
            }

            // Close the document and save it to the output stream
            document.save(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    

    @Override
    public String getServletInfo() {
        return "SurplusItems Servlet";
    }// </editor-fold>

}
