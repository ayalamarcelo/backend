package java.application.services;

import java.domain.models.Pelicula;
import java.infrastructure.repository.PeliculaDAO;

import java.sql.Connection;
import java.util.List;

public class PeliculaService implements IPersistencia<Pelicula> {
    private final PeliculaDAO peliculaDAO;

    public PeliculaService(Connection conexion) {
        this.peliculaDAO = new PeliculaDAO();
    }

    @Override
    public void crear(Pelicula pelicula) {
        peliculaDAO.crear(pelicula);
    }

    @Override
    public Pelicula leer(int id) {
        return peliculaDAO.leer(id);
    }

    @Override
    public List<Pelicula> leerTodos() {
        return peliculaDAO.leerTodos();
    }

    @Override
    public void actualizar(Pelicula pelicula) {
        peliculaDAO.actualizar(pelicula);
    }

    @Override
    public void eliminar(int id) {
        peliculaDAO.eliminar(id);
    }
}
