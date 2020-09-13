DROP TABLE IF EXISTS teams CASCADE;
DROP TABLE IF EXISTS matches CASCADE;

CREATE TABLE users(
    id serial PRIMARY KEY UNIQUE,
    name varchar (99) NOT NULL,
    surname varchar (99) NOT NULL,
    email varchar (99) NOT NULL,
    phoneNumber integer (99) NOT NULL
);

CREATE TABLE tables(
    id serial PRIMARY KEY UNIQUE,
    tableNumber integer NOT NULL,
    numberOfSeats integer NOT NULL,
);
