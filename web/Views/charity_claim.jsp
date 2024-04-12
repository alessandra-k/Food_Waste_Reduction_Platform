<%-- 
    Document   : charity_claim
    Created on : Apr. 11, 2024, 5:26:06 p.m.
    Author     : allan
--%>

<%@page import="Model.DonationItems"%>
<%@page import="BusinessLayer.InventoryBusinessLogic"%>
<%@page import="java.util.List"%>
<%@page import="Model.Claim"%>
<%@page import="BusinessLayer.ClaimBusinessLogic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Claim Food</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
    <header>
        <h1>Claim Food</h1>
        <div class="claim-food-nav">
            <nav>
                <ul>
                    <li><a href="Charity_Servlet?action=CharityHome">Charity Home</a></li>
                    <li><a href="Charity_Servlet?action=Subscription">Subscription</a></li>
                    <li><a href="#donationlist">Donation List</a></li>
                    <li><a href="#claimedfood">Claimed Food</a></li>
                    <li><a href="Charity_Servlet?action=Logout">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <main>
        <section id="donationlist" class="donation-list-section">
            <h2>Donation List</h2>
            <!-- This section will be dynamically populated from the database -->
            <!-- Each item will include details like item name, description, quantity, etc. -->
        </section>
        <section class="claim-form-section">
            <h2>Claim Food</h2>
            <form method="post" action="Charity_Servlet">
                <table>
                    <thead>
                        <tr>
                            <th>Item ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Expiration Date</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            InventoryBusinessLogic inventoryLogic = new InventoryBusinessLogic();
                            List<DonationItems> donationItems = inventoryLogic.getDonationItems();
                            for (DonationItems donationItem : donationItems) {
                        %>
                        <tr>
                            <td><%= donationItem.getItemId()%></td>
                            <td><%= donationItem.getName()%></td>
                            <td><%= donationItem.getDescription()%></td>
                            <td><%= donationItem.getExpirationDate()%></td>
                            <td><%= donationItem.getQuantity()%></td>
                            <td><input type="number" name="ItemClaimed_+<%= donationItem.getItemId()%>" min="0" max="<%= donationItem.getQuantity()%>"></td>

                        </tr>
                        <% }%>
                    </tbody>
                </table>
                <button type="submit" class="button">Claim</button>
        </form>
        </section>
        <section id="claimedfood" class="claimed-food-section">
            <h2>Claimed Food</h2>
            <!-- This section will display items claimed by the charity -->
            <!-- Each item will have a button to remove it if the charity doesn't want it -->
        </section>
    </main>
    <footer>
        <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
    </footer>
</body>
</html>
