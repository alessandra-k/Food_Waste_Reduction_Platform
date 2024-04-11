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
                        <li><a href="retailers.html">Retailer Home</a></li>
                        <li><a href="#inventorylist">List</a></li>
                        <li><a href="#flagfood">Flag Food</a></li>
                        <li><a href="#surplusfood">Donation/Sale</a></li>
                        <li><a href="inventory-retailer.html">Inventory Management</a></li>
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
            <section id="inventorylist" class="inventory-list-section">
                <h2>Exipring Items</h2>
                <ul>
                    <%
                        List<Item> expiringItems = inventoryLogic.getItemsCloseToExpiration();
                        for (Item item : expiringItems) {
                    %>
                    <li>
                        <div>
                            <h3><%= item.getName()%></h3>
                            <p>Description: <%= item.getDescription()%></p>
                            <p>Price: <%= item.getPrice()%></p>
                            <p>Expiration Date: <%= item.getExpirationDate()%></p>
                        </div>
                    </li>
                    <% }%>
                </ul>
            </section>
            <section id="inventorylist" class="inventory-list-section">
                <h2>Sale Items List</h2>
                <ul>
                    <%
                        List<SalesItems> salesItems = inventoryLogic.getItemsWithDiscount();

                        for (SalesItems salesItem : salesItems) {%>
                    <li>
                        <div>
                            <h3><%= salesItem.getName()%></h3>
                            <p>Description: <%= salesItem.getDescription()%></p>
                            <p>Price: <%= salesItem.getPrice()%></p>
                            <p>Expiration Date: <%= salesItem.getExpirationDate()%></p>
                            <p>Quantity: <%= salesItem.getQuantity()%></p>
                            <p>Discount: <%= salesItem.getDiscountDescription()%></p>
                        </div>
                    </li>
                    <% }%>
                </ul>
            </section>

            <section id="surplusfood" class="surplus-list-section">
                <h2>Donation List</h2>
                <ul>
                    <%

                        List<DonationItems> donationItems = inventoryLogic.getDonationItems();

                        for (DonationItems donationItem : donationItems) {%>
                    <li>
                        <div>
                            <h3><%= donationItem.getName()%></h3>
                            <p>Description: <%= donationItem.getDescription()%></p>
                            <p>Price: <%= donationItem.getPrice()%></p>
                            <p>Expiration Date: <%= donationItem.getExpirationDate()%></p>
                            <p>Quantity: <%= donationItem.getQuantity()%></p>
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
