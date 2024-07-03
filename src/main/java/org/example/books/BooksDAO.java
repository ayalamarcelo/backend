package org.example.books;

public class BooksDAO {
    package com.example.peliculas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

    public class PeliculaDAO {

        public void crearPelicula(Pelicula pelicula) {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "INSERT INTO peliculas (titulo, director, ano, genero) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, pelicula.getTitulo());
                statement.setString(2, pelicula.getDirector());
                statement.setInt(3, pelicula.getAno());
                statement.setString(4, pelicula.getGenero());
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public List<Pelicula> leerPeliculas() {
            List<Pelicula> peliculas = new ArrayList<>();
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "SELECT * FROM peliculas";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String titulo = resultSet.getString("titulo");
                    String director = resultSet.getString("director");
                    int ano = resultSet.getInt("ano");
                    String genero = resultSet.getString("genero");
                    Pelicula pelicula = new Pelicula(id, titulo, director, ano, genero);
                    peliculas.add(pelicula);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return peliculas;
        }

        public void actualizarPelicula(Pelicula pelicula) {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "UPDATE peliculas SET titulo = ?, director = ?, ano = ?, genero = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, pelicula.getTitulo());
                statement.setString(2, pelicula.getDirector());
                statement.setInt(3, pelicula.getAno());
                statement.setString(4, pelicula.getGenero());
                statement.setInt(5, pelicula.getId());
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void borrarPelicula(int id) {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "DELETE FROM peliculas WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
