package org.infrastructure.database;

import org.application.adapters.IRepository;
import org.domain.models.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLRepositoryImpl implements IRepository {

    private final Connection connection;

    public MySQLRepositoryImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void saveMovie(Movie movie) {
        String sql = "INSERT INTO movies (title, director, genre) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparer = this.connection.prepareStatement(sql);
            preparer.setString(1, movie.getTitle());
            preparer.setString(2, movie.getDirector());
            preparer.setString(3, movie.getGenre());

            preparer.executeUpdate();
            preparer.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Movie findByTitle(String title) {
        String sql = "SELECT * FROM movies WHERE title = ?";
        try {
            PreparedStatement preparer = this.connection.prepareStatement(sql);
            preparer.setString(1, title);

            ResultSet virtualTable = preparer.executeQuery();

            if(virtualTable.next()) {
                Movie movie = new Movie();
                movie.setId(virtualTable.getInt("id"));
                movie.setTitle(virtualTable.getString("title"));
                movie.setDirector(virtualTable.getString("director"));
                movie.setGenre(virtualTable.getString("genre"));
                return movie;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public void deleteMovie(int id) {
        String sql = "DELETE FROM movies WHERE id = ?";

        try {
            PreparedStatement preparer = this.connection.prepareStatement(sql);
            preparer.setInt(1, id);

            preparer.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateMovie(Movie movie) {
        String sql = "UPDATE movies SET title = ?, director = ?, genre = ? WHERE id = ?";
        
        // Use a logger instead of System.out.println
        Logger logger = Logger.getLogger(this.getClass().getName());
    
        // Try-with-resources to ensure resources are closed
        try (PreparedStatement preparer = this.connection.prepareStatement(sql)) {
            preparer.setString(1, movie.getTitle());
            preparer.setString(2, movie.getDirector());
            preparer.setString(3, movie.getGenre());
            preparer.setInt(4, movie.getId());
    
            int updated = preparer.executeUpdate();
            logger.log(Level.INFO, "Updated files: {0}", updated);
            return updated > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating files", e);
            throw new RuntimeException("Error updating files", e);
        }
    }
}
