DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS restaurant;

CREATE TABLE customer(
    id serial PRIMARY KEY UNIQUE,
    name varchar (99) NOT NULL,
    surname varchar (99) NOT NULL,
    email varchar (99) NOT NULL,
    phonenumber integer NOT NULL,
    imageurl VARCHAR(255) DEFAULT NULL
   
);

INSERT INTO customer (id, name, surname, email, phonenumber, imageurl) VALUES (1, 'Konrad', 'Siekacz', 'konradius@codecool.com', 89, 'assets/images/products/placeholder.png');
INSERT INTO customer (id, name, surname, email, phonenumber, imageurl) VALUES (2, 'Przemek', 'Płoskonka', 'plaski@codecool.com', 89, 'assets/images/products/placeholder.png');
INSERT INTO customer (id, name, surname, email, phonenumber, imageurl) VALUES (3, 'Martin', 'Zak', 'marzako@codecool.com', 89, 'assets/images/products/placeholder.png');
INSERT INTO customer (id, name, surname, email, phonenumber, imageurl) VALUES (4, 'Michal', 'Hanusniak', 'mhanusniak@codecool.com', 78, 'assets/images/products/placeholder.png');

CREATE TABLE restaurant(
    id serial PRIMARY KEY UNIQUE,
    name varchar (99) NOT NULL,
    address varchar (99) NOT NULL,
    imageurl VARCHAR(255) DEFAULT NULL,
    average_price_for_meal integer NOT NULL
);


INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal ) VALUES (1, 'PizzaPasta', 'Dajwor 23, Krakow','assets/images/restaurants/pizzapasta.jpg',35);
INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal) VALUES (2, 'Kolonko', 'Nie wiem 15, Krakow','assets/images/restaurants/kolonko.jpg', 27);
INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal) VALUES (3, 'Ramen Krakow', 'Koronavirus 17, Krakow','assets/images/restaurants/ramenkrakow.jpg', 17);
INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal) VALUES (4, 'Hana sushi', 'Starowislna 55, Krakow','assets/images/restaurants/hanasushi.jpg',28);
INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal) VALUES (5, 'Pizza Planet', 'SNP 1196, Krakow','assets/images/restaurants/pizzaplanet.png',47);
INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal) VALUES (6, 'Taco Hell', 'Hellfire peninsula 17, Outland','assets/images/restaurants/tacohell.jpg',24);
INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal) VALUES (7, 'Konoha Ramen', 'Narutowicza, Konoha','assets/images/restaurants/konoharamen.jpg',27);
INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal) VALUES (8, 'Jamie Crab', 'Total waste 17, Lonelyland','assets/images/restaurants/jamiecrab.jpg',23);
INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal) VALUES (9, 'Lobster heaven', 'Yummy slash 75, Yummyland','assets/images/restaurants/lobster.jpg',69);

CREATE TABLE reservation_item(
    reservation_item_id serial PRIMARY KEY UNIQUE,
    restaurant_name varchar (99) NOT NULL,
    id integer NOT NULL,
    table_id integer NOT NULL,
    number_in_restaurant VARCHAR(255) DEFAULT NULL,
    number_of_seats VARCHAR(255) DEFAULT NULL
);

INSERT INTO reservation_item(reservation_item_id, id, number_in_restaurant, number_of_seats, restaurant_name, table_id) VALUES (1, 8, 2, 2, 'Jamie Crab', 2);


reservation_item_id | id | number_in_restaurant | number_of_seats | restaurant_name | table_id 


--CREATE TABLE restaurant(
--    id serial PRIMARY KEY UNIQUE,
--    name varchar (99) NOT NULL,
--    address varchar (99) NOT NULL
--);
--
--INSERT INTO restaurant (id, name, address) VALUES (1, 'PizzaPasta', 'Dajwor 23, Krakow');
--INSERT INTO restaurant (id, name, address) VALUES (4, 'PizzaPasta', 'Dajwor 23, Krakow');
--INSERT INTO restaurant (id, name, address) VALUES (5, 'PizzaPasta', 'Dajwor 23, Krakow');
--INSERT INTO restaurant (id, name, address) VALUES (6, 'PizzaPasta', 'Dajwor 23, Krakow');
--INSERT INTO restaurant (id, name, address) VALUES (8, 'PizzaPasta', 'Dajwor 23, Krakow');
--INSERT INTO restaurant (id, name, address) VALUES (9, 'PizzaPasta', 'Dajwor 23, Krakow');
--INSERT INTO restaurant (id, name, address) VALUES (10, 'PizzaPasta', 'Dajwor 23, Krakow');

