<%-- 
    Document   : mySubscriptionPage
    Created on : Apr 11, 2024, 2:38:49 PM
    Author     : morio
--%>

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
    <div class="my-subscribe-nav">
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
            <h2>Subscription Details</h2>
            <p><strong>Neighborhood:</strong> Downtown</p>
            <p><strong>Communication Method:</strong> Email</p>
            <p><strong>Food Preferences:</strong> Vegetarian, Gluten Free</p>
            <form action="MySubscription_Servlet" method="post">
                <button type="button" class="button">Unsubscribe</button>
            </form>
        </section>
     </main>
<footer>
            <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
        </footer>
    </body>
</html>