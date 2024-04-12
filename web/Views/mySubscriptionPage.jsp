<%-- 
    Document   : mySubscriptionPage
    Created on : Apr 11, 2024, 2:38:49 PM
    Author     : morio
Peace added this page
--%>

<%@page import="java.util.List"%>
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
                <li><a href="Subscription_Servlet">Subscription</a></li>
            </ul>
        </nav>
    </div>
</header>
     <main>
     <section class="my-subscription-details">
         
         <%-- Add this code to display the message --%>
    <% String message = (String) request.getAttribute("message");
       if (message != null) { %>
       <script>
           alert("<%= message %>");
       </script>
    <% } %>
            <h2>Subscription Details</h2>
            <p><strong>Neighborhood:</strong> <%= request.getAttribute("neighbourhood") %></p>
    <p><strong>Communication Method:</strong> <%= request.getAttribute("communicationMethod") %></p>
        <p><strong>Food Preferences:</strong> 
    <%
        List<String> foodPreferences = (List<String>) request.getAttribute("foodPreferences");
        if (foodPreferences != null && !foodPreferences.isEmpty()) {
            out.println(foodPreferences.get(0));
        } else {
            out.println("No food preferences selected");
        }
    %>
    </p>
    <%-- Add this code to display notifications --%>
    <% List<String> notifications = (List<String>) request.getAttribute("notifications");
       if (notifications != null && !notifications.isEmpty()) { %>
       <h3>Notifications:</h3>
       <ul>
           <% for (String notification : notifications) { %>
               <li><%= notification %></li>
           <% } %>
       </ul>
    <% } else { %>
       <p>No notifications</p>
    <% } %>
    <form action="MySubscription_Servlet" method="post">
    <button type="submit" name="unsubscribe" class="button">Unsubscribe</button>
    </form>

        </section>
     </main>
<footer>
            <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
        </footer>
    </body>
</html>