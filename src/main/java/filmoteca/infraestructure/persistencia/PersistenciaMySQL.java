package filmoteca.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersistenciaMySQL implements IPersistencia {

    private Connection conexion = DatabaseConnection.getConnection();

    @Override
    public void guardarPeliculas(ArrayList<Pelicula> peliculas) {
        String insertSQL = "INSERT INTO peliculas (titulo, director, anio, genero) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparador = conexion.prepareStatement(insertSQL);

            for (Pelicula pelicula : peliculas) {
                preparador.setString(1, pelicula.getTitulo());
                preparador.setString(2, pelicula.getDirector());
                preparador.setInt(3, pelicula.getAnio());
                preparador.setString(4, pelicula.getGenero());
                preparador.addBatch();
            }

            preparador.executeBatch();
            System.out.println("Peliculas guardadas en Base de Datos...");
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar las películas en la base de datos", e);
        }
    }

    @Override
    public ArrayList<Pelicula> traerRegistrosPeliculas() {
        String selectSQL = "SELECT * FROM peliculas";
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            PreparedStatement preparador = conexion.prepareStatement(selectSQL);
            ResultSet tablaSet = preparador.executeQuery();

            while (tablaSet.next()) {
                String titulo = tablaSet.getString("titulo");
                String director = tablaSet.getString("director");
                int anio = tablaSet.getInt("anio");
                String genero = tablaSet.getString("genero");

                Pelicula pelicula = new Pelicula();
                pelicula.setTitulo(titulo);
                pelicula.setDirector(director);
                pelicula.setAnio(anio);
                pelicula.setGenero(genero);

                peliculas.add(pelicula);
            }
            return peliculas;

        } catch (SQLException e) {
            throw new RuntimeException("Error al traer los registros de películas de la base de datos", e);
        }
    }

    @Override
    public void actualizarPelicula(String directorNuevo, int anio) {
        String updateSQL = "UPDATE peliculas SET director = ? WHERE anio = ?";
        try {
            PreparedStatement preparador = conexion.prepareStatement(updateSQL);
            preparador.setString(1, directorNuevo);
            preparador.setInt(2, anio);
            int filasAfectadas = preparador.executeUpdate();
            System.out.printf("Se han actualizado %d registros\n", filasAfectadas);

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la película en la base de datos", e);
        }
    }

    @Override
    public void borrarPelicula(int id) {
        String deleteSQL = "DELETE FROM peliculas WHERE id = ?";
        try {
            PreparedStatement preparador = conexion.prepareStatement(deleteSQL);
            preparador.setInt(1, id);
            preparador.executeUpdate();
            System.out.println("Se ha borrado la película con id " + id);

        } catch (SQLException e) {
            throw new RuntimeException("Error al borrar la película de la base de datos", e);
        }
    }
}
