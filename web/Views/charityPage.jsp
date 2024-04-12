<%-- 
    Document   : charityPage
    Created on : Mar. 22, 2024, 1:47:54 p.m.
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Charitable Organization</title>
  <link rel="stylesheet" href="CSS/style.css" type="text/css"/>
</head>
<body>
    <header>
        <h1>Welcome Charitable Organization</h1>
        <div class="charity-nav">
            <nav>
                <ul>
                    <li><a href="Charity_Servlet?action=Claim">Claim Food</a></li>
                    <li><a href="Charity_Servlet?action=Subscription">Subscription</a></li>
                    <li><a href="Charity_Servlet?action=Logout">Logout</a></li>
                </ul>
            </nav>
        </div>
        
    </header>
    <main>
        <section class="welcome-section">
            <h2>Welcome to Our Food Donation Platform!</h2>
            <p>As a charitable organization, you play a vital role in distributing surplus food to those in need. Explore our platform to claim surplus food items listed by retailers.</p>
        </section>
    </main>
    <footer>
        <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
    </footer>
</body>
</html>
