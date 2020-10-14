drop table if exists restaurant_table;
DROP TABLE IF EXISTS restaurant;


CREATE TABLE restaurant(
    id serial PRIMARY KEY UNIQUE,
    name varchar (99) NOT NULL,
    address varchar (99) NOT NULL,
    imageurl VARCHAR(255) DEFAULT NULL,
    average_price_for_meal integer NOT NULL,
    user_id integer,
    CONSTRAINT fk_user
      FOREIGN KEY(id) 
	  REFERENCES users(id)
);

INSERT INTO restaurant (id, name, address, imageurl, average_price_for_meal, user_id) VALUES (1, 'PizzaPasta', 'Dajwor 23, Krakow','assets/images/restaurants/pizzapasta.jpg',35, 1);
--INSERT INTO restaurant (restaurant_id, name, address, imageurl, average_price_for_meal, user_id) VALUES (2, 'Kolonko', 'Nie wiem 15, Krakow','assets/images/restaurants/kolonko.jpg', 27, 2);
--INSERT INTO restaurant (restaurant_id, name, address, imageurl, average_price_for_meal, user_id) VALUES (3, 'Ramen Krakow', 'Koronavirus 17, Krakow','assets/images/restaurants/ramenkrakow.jpg', 17, 3);
--INSERT INTO restaurant (restaurant_id, name, address, imageurl, average_price_for_meal, user_id) VALUES (4, 'Hana sushi', 'Starowislna 55, Krakow','assets/images/restaurants/hanasushi.jpg',28, 4);
--INSERT INTO restaurant (restaurant_id, name, address, imageurl, average_price_for_meal, user_id) VALUES (5, 'Pizza Planet', 'SNP 1196, Krakow','assets/images/restaurants/pizzaplanet.png',47, 5);
--INSERT INTO restaurant (restaurant_id, name, address, imageurl, average_price_for_meal, user_id) VALUES (6, 'Taco Hell', 'Hellfire peninsula 17, Outland','assets/images/restaurants/tacohell.jpg',24, 6);
--INSERT INTO restaurant (restaurant_id, name, address, imageurl, average_price_for_meal, user_id) VALUES (7, 'Konoha Ramen', 'Narutowicza, Konoha','assets/images/restaurants/konoharamen.jpg',27, 7);
--INSERT INTO restaurant (restaurant_id, name, address, imageurl, average_price_for_meal, user_id) VALUES (8, 'Jamie Crab', 'Total waste 17, Lonelyland','assets/images/restaurants/jamiecrab.jpg',23, 8);
--INSERT INTO restaurant (restaurant_id, name, address, imageurl, average_price_for_meal, user_id) VALUES (9, 'Lobster heaven', 'Yummy slash 75, Yummyland','assets/images/restaurants/lobster.jpg',69, 9);

INSERT INTO restaurant_table (table_id, number_in_restaurant, number_of_seats, id) VALUES (1, 1, 4, 1);

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

