DROP DATABASE IF EXISTS FWRP;

CREATE DATABASE FWRP;

USE FWRP;

CREATE TABLE UserType (
    userType_id INT PRIMARY KEY,
    userType VARCHAR(255) -- Description of the user type
);

INSERT INTO UserType (userType_id, userType)
VALUES 
    (1, 'RETAILER'),
    (2, 'CONSUMER'),
    (3, 'CHARITY');

CREATE TABLE User (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(255),
    userEmail VARCHAR(255),
    userPassword VARCHAR(255),
    userType_id INT,
    address_id INT,
    phone VARCHAR(20),
FOREIGN KEY (userType_id) REFERENCES UserType(userType_id) 
);

CREATE TABLE Address (
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    street VARCHAR(255),
    postalCode VARCHAR(20),
    user_id INT    
);

ALTER TABLE Address
ADD CONSTRAINT FK_UserAddress FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE;

ALTER TABLE User
ADD CONSTRAINT FK_AddressUser FOREIGN KEY (address_id) REFERENCES Address(address_id) ON DELETE CASCADE;

CREATE TABLE Discount (
    discount_id INT PRIMARY KEY,
    rate DECIMAL(5, 2),
    discount_description VARCHAR(255) -- Description of the discount
);

INSERT INTO Discount (discount_id, rate, discount_description) VALUES 
(1, 0.0, ' '),
(2, 0.1, '10%'),
(3, 0.2, '20%'),
(4, 0.3, '30%'),
(5, 0.4, '40%'),
(6, 0.5, '50%');

CREATE TABLE Item (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(10, 2),
    expirationDate DATE,
    forDonation BOOLEAN,
    discount_id INT,
    FOREIGN KEY (discount_id) REFERENCES Discount(discount_id)
);

CREATE TABLE Inventory (
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    item_id INT,
    quantity INT,
    FOREIGN KEY (item_id) REFERENCES Item(item_id)
);

CREATE TABLE CommunicationMethod (
    communicationMethod_id INT PRIMARY KEY,
    communicationMethod_type VARCHAR(255) -- Description of the communication method
);
CREATE TABLE FoodPreference (
    foodPreferences_id INT PRIMARY KEY,
	foodPreferences_description VARCHAR(255) -- Description of the food preference
);

CREATE TABLE Neighbourhood (
    neighbourhood_id INT PRIMARY KEY,
    neighbourhood VARCHAR(255) -- Description of the neighbourhood
);

CREATE TABLE Subscription (
    subscription_id INT PRIMARY KEY KEY AUTO_INCREMENT,
    neighbourhood_id INT,
    communicationMethod_id INT,
    foodPreferences_id INT,
    user_id INT,
    FOREIGN KEY (neighbourhood_id) REFERENCES Neighbourhood(neighbourhood_id),
    FOREIGN KEY (communicationMethod_id) REFERENCES CommunicationMethod(communicationMethod_id),
    FOREIGN KEY (foodPreferences_id) REFERENCES FoodPreference(foodPreferences_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);
INSERT INTO Neighbourhood (neighbourhood_id, neighbourhood) VALUES 
(1, 'HINTONBURG'),
(2, 'TUNNEYS_PASTURE'),
(3, 'WESTBORO'),
(4, 'THE_GLEBE'),
(5, 'HUNT_CLUB'),
(6, 'STITTSVILLE_KANATA'),
(7, 'CARLETON_PLACE'),
(8, 'BARRHAVEN'),
(9, 'ORLEANS'),
(10, 'RIVERSIDE_SOUTH'),
(11, 'SANDY_HILL'),
(12, 'ALTA_VISTA');

INSERT INTO CommunicationMethod (communicationMethod_id, communicationMethod_type) VALUES 
(1, 'EMAIL'),
(2, 'PHONE');

INSERT INTO FoodPreference (foodPreferences_id, foodPreferences_description) VALUES 
(1, 'VEGAN'),
(2, 'VEGETARIAN'),
(3, 'GLUTEN_FREE'),
(4, 'DAIRY_FREE'),
(5, 'NUT_FREE'),
(6, 'LACTOSE_FREE'),
(7, 'HEALTH_CONSCIOUS'),
(8, 'HALAL');

Select * from item;
Select * from user;
Select * from inventory;