package java.infrastructure.repository.controllers;

import java.domain.models.Pelicula;
import java.application.services.PeliculaService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(Connection conexion) {
        this.peliculaService = new PeliculaService(conexion);
    }

    public void crearPelicula(Pelicula pelicula) throws SQLException {
        peliculaService.crear(pelicula); // Delega la creación a PeliculaService
    }

    public Pelicula obtenerPelicula(int id) throws SQLException {
        return peliculaService.leer(id); // Delega la lectura a PeliculaService
    }

    public List<Pelicula> obtenerTodasLasPeliculas() throws SQLException {
        return peliculaService.leerTodos(); // Delega la lectura de todas las películas a PeliculaService
    }

    public void actualizarPelicula(Pelicula pelicula) throws SQLException {
        peliculaService.actualizar(pelicula); // Delega la actualización a PeliculaService
    }

    public void eliminarPelicula(int id) throws SQLException {
        peliculaService.eliminar(id); // Delega la eliminación a PeliculaService
    }
}
