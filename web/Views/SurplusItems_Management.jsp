<%-- 
    Document   : SurplusItems_Management
    Created on : Apr. 11, 2024, 3:55:20 a.m.
    Author     : aless
--%>

<%@page import="Model.Item"%>
<%@page import="Model.ExcessDemandItems"%>
<%@page import="Model.DonationItems"%>
<%@page import="BusinessLayer.InventoryBusinessLogic"%>
<%@page import="Model.SalesItems"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Surplus Food Management</title>
        <link rel="stylesheet" href="CSS/style.css" type="text/css">

    </head>
    <body>
        <header>
            <h1>Surplus Food Management</h1>
            <div class="surplus-food-nav">
                <nav>
                    <ul>
                        <li><a href="SurplusItems_Servlet?action=RetailerHome">Retailer Home</a></li>
                        <li><a href="SurplusItems_Servlet?action=InventoryManagement">Inventory Management</a></li>
                        <li><a href="SurplusItems_Servlet?action=ExcessDemandItems">Excess Demand Items</a></li>
                        <li><a href="SurplusItems_Servlet?action=ExpiringItems">Expiring Items</a></li>
                        <li><a href="SurplusItems_Servlet?action=Sales">Sales</a></li>
                        <li><a href="SurplusItems_Servlet?action=Donation">Donation</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </nav>
            </div>

        </header>
        <main>
            <section id="inventorylist" class="inventory-list-section">
                <h2>Excess Demand Items</h2>
                <ul>
                    <%
                        InventoryBusinessLogic inventoryLogic = new InventoryBusinessLogic();
                        List<ExcessDemandItems> excessDemandItems = inventoryLogic.getItemsWithExcessDemand();

                        for (ExcessDemandItems item : excessDemandItems) {
                    %>
                    <li>
                        <div>
                            <h3><%= item.getName()%></h3>
                            <p>Description: <%= item.getDescription()%></p>
                            <p>Price: <%= item.getPrice()%></p>
                            <p>Expiration Date: <%= item.getExpirationDate()%></p>
                            <p>Quantity: <%= item.getQuantity()%></p>
                        </div>
                    </li>
                    <% }%>
                </ul>
            </section>

        </main>
        <footer>
            <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
        </footer>
    </body>
</html>
