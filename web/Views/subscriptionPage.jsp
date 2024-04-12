<%-- 
    Document   : subscriptionPage
    Created on : Mar. 22, 2024, 1:48:15 p.m.
    Author     : morio
Peace Added this
--%>

<%@page import="Model.FoodPreference"%>
<%@page import="Model.CommunicationMethod"%>
<%@page import="Model.Neighbourhood"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subscribe to Surplus Food Alerts</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/style.css" type="text/css"/>
</head>
<body>

<header>
    <h1>Subscribe to Surplus Food Alerts</h1>
    <div class="subscribe-nav">
        <nav>
            <ul>
                <li><a href="index.html">Logout</a></li>
                <li><a href="MySubscription_Servlet">My Subscription</a></li>
            </ul>
        </nav>
    </div>
</header>
    <script>
    // Check if success message is available
    <% if (request.getAttribute("successMessage") != null) { %>
        // Create a modal dialog for the success message
        var modal = document.createElement("div");
        modal.classList.add("modal");

        // Modal content
        var modalContent = document.createElement("div");
        modalContent.classList.add("modal-content");
        modalContent.innerHTML = "<p><%= request.getAttribute("successMessage") %></p><button id='closeModal'>OK</button>";
        modal.appendChild(modalContent);

        // Add modal to the document body
        document.body.appendChild(modal);

        // Function to close the modal
        function closeModal() {
            modal.style.display = "none";
        }

        // Close modal when clicking on OK button
        document.getElementById("closeModal").onclick = function() {
            closeModal();
        };

        // Close modal when clicking outside of it
        window.onclick = function(event) {
            if (event.target === modal) {
                closeModal();
            }
        };

        // Show the modal
        modal.style.display = "block";
    <% } %>
</script>
<main>
    <section class="subscription-form-section">
        <h2>Subscription Form</h2>
        <form action="Subscription_Servlet" method="post">
            <div class="form-group">
                <label for="neighborhood">Neighborhood:</label>
                <select id="neighborhood" name="neighborhood" required>
                    <% for (Neighbourhood neighborhood : Neighbourhood.values()) { %>
                        <option value="<%= neighborhood.getNeighbourhood_id() %>"><%= neighborhood.name() %></option>
                    <% } %>
                </select>
            </div>
            <div class="form-group">
                <label for="communication-method">Communication Method:</label>
                <select id="communication-method" name="communicationMethod" required>
                    <% for (CommunicationMethod method : CommunicationMethod.values()) { %>
                        <option value="<%= method.getCommunicationMethod_id() %>"><%= method.name() %></option>
                    <% } %>
                </select>
            </div>
            <div class="form-group">
                <label for="food-preferences">Food Preferences:</label>
                <select id="food-preferences" name="foodPreferences" multiple required>
                    <% for (FoodPreference preference : FoodPreference.values()) { %>
                        <option value="<%= preference.getFoodPreferences_id() %>"><%= preference.name() %></option>
                    <% } %>
                </select>
            </div>
            <button type="submit" class="button">Subscribe</button>
        </form>
    </section>
</main>
<footer>
    <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
</footer>
                
       <%-- JavaScript code to display success message in a pop-up dialog box --%>

         
</body>
</html>
