-- Crear la base de datos
CREATE DATABASE movies_db;

-- Usar la base de datos
USE movies_db;

-- Crear la tabla peliculas
CREATE TABLE peliculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    genero VARCHAR(100)
);

-- Consultar todos los registros de la tabla peliculas
SELECT * FROM peliculas;
