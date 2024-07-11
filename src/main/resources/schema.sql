/* Create database */
CREATE DATABASE IF NOT EXISTS filmoteca;

/*Use database*/
USE filmoteca;

/*Create Table*/
CREATE TABLE IF NOT EXISTS peliculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    anio INT,
    genero VARCHAR(100)
);

/*Inserts*/
INSERT INTO peliculas (titulo, director, anio, genero) VALUES
('The Godfather', 'Francis Ford Coppola', 1972, 'Crime'),
('The Dark Knight', 'Christopher Nolan', 2008, 'Action'),
('Forrest Gump', 'Robert Zemeckis', 1994, 'Drama'),
('The Matrix', 'Lana Wachowski, Lilly Wachowski', 1999, 'Sci-Fi'),
('Schindler''s List', 'Steven Spielberg', 1993, 'Biography'),
('The Lord of the Rings: The Fellowship of the Ring', 'Peter Jackson', 2001, 'Adventure'),
('Titanic', 'James Cameron', 1997, 'Romance'),
('Avatar', 'James Cameron', 2009, 'Action'),
('Interstellar', 'Christopher Nolan', 2014, 'Sci-Fi'),
('Inglourious Basterds', 'Quentin Tarantino', 2009, 'War');