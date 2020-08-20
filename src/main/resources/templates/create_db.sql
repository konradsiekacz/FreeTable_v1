DROP TABLE IF EXISTS teams CASCADE;
DROP TABLE IF EXISTS matches CASCADE;

CREATE TABLE users(
    id serial PRIMARY KEY UNIQUE,
    name varchar (99) NOT NULL,
    surname varchar (99) NOT NULL,
    email varchar (99) NOT NULL,
    phoneNumber integer (99) NOT NULL
);

CREATE TABLE matches(
    match_id serial PRIMARY KEY UNIQUE,
    date date NOT NULL,
    home_team_id integer NOT NULL,
    away_team_id integer NOT NULL,
    goals_home integer NOT NULL,
    goals_away integer NOT NULL
);