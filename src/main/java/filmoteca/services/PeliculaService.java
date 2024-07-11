package filmoteca.services;

import filmoteca.database.PeliculaDAO;
import filmoteca.domain.models.Pelicula;

import java.util.List;

public class PeliculaService {
    private PeliculaDAO peliculaDAO;

    public PeliculaService() {
        this.peliculaDAO = new PeliculaDAO();
    }

    public void crearPelicula(Pelicula pelicula) {
        peliculaDAO.crearPelicula(pelicula);
    }

    public Pelicula leerPelicula(int id) {
        return peliculaDAO.leerPelicula(id);
    }

    public List<Pelicula> leerTodasLasPeliculas() {
        return peliculaDAO.leerTodasLasPeliculas();
    }

    public void actualizarPelicula(Pelicula pelicula) {
        peliculaDAO.actualizarPelicula(pelicula);
    }

    public void eliminarPelicula(int id) {
        peliculaDAO.eliminarPelicula(id);
    }
}
