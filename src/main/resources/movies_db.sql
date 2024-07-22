-- Create
CREATE DATABASE movies_db;

-- Use
USE movies_db;

-- Create movies table
CREATE TABLE movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    genre VARCHAR(100)
);

-- Show table
SELECT * FROM movies;
