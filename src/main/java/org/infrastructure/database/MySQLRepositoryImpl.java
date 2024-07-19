package org.infrastructure.database;

import org.application.adapters.IRepository;
import org.domain.models.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLRepositoryImpl implements IRepository {

    private final Connection conexion;

    public MySQLRepositoryImpl() {
        this.conexion = DatabaseConnection.getConnection();
    }

    @Override
    public void savePelicula(Pelicula pelicula) {
        String sql = "INSERT INTO peliculas (titulo, director, genero) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparer = this.conexion.prepareStatement(sql);
            preparer.setString(1, pelicula.getTitulo());
            preparer.setString(2, pelicula.getDirector());
            preparer.setString(3, pelicula.getGenero());

            preparer.executeUpdate();
            preparer.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pelicula findByTitulo(String titulo) {
        String sql = "SELECT * FROM peliculas WHERE titulo = ?";
        try {
            PreparedStatement preparer = this.conexion.prepareStatement(sql);
            preparer.setString(1, titulo);

            ResultSet virtualTable = preparer.executeQuery();

            if(virtualTable.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setId(virtualTable.getInt("id"));
                pelicula.setTitulo(virtualTable.getString("titulo"));
                pelicula.setDirector(virtualTable.getString("director"));
                pelicula.setGenero(virtualTable.getString("genero"));
                return pelicula;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public void deletePelicula(int id) {
        String sql = "DELETE FROM peliculas WHERE id = ?";

        try {
            PreparedStatement preparer = this.conexion.prepareStatement(sql);
            preparer.setInt(1, id);

            preparer.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePelicula(Pelicula pelicula) {
        String sql = "UPDATE peliculas SET titulo = ?, director = ?, genero = ? WHERE id = ?";
        
        // Use a logger instead of System.out.println
        Logger logger = Logger.getLogger(this.getClass().getName());
    
        // Try-with-resources to ensure resources are closed
        try (PreparedStatement preparer = this.conexion.prepareStatement(sql)) {
            preparer.setString(1, pelicula.getTitulo());
            preparer.setString(2, pelicula.getDirector());
            preparer.setString(3, pelicula.getGenero());
            preparer.setInt(4, pelicula.getId());
    
            int updated = preparer.executeUpdate();
            logger.log(Level.INFO, "Los archivos se actualizaron: {0}", updated);
            return updated > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating Pelicula", e);
            throw new RuntimeException("Error updating Pelicula", e);
        }
    }
}
