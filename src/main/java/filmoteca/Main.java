package filmoteca;

import filmoteca.database.PeliculaDAO;
import filmoteca.domain.models.Pelicula;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();

        // Crear una nueva película
        Pelicula nuevaPelicula = new Pelicula("Inception", "Christopher Nolan", 2010, "Sci-Fi");
        peliculaDAO.crearPelicula(nuevaPelicula);

        // Leer una película por id
        Pelicula pelicula = peliculaDAO.leerPelicula(1);
        System.out.println("Leer Película: " + pelicula.getTitulo());

        // Leer todas las películas
        List<Pelicula> peliculas = peliculaDAO.leerTodasLasPeliculas();
        peliculas.forEach(p -> System.out.println("Película: " + p.getTitulo()));

        // Actualizar una película
        pelicula.setTitulo("Inception Updated");
        peliculaDAO.actualizarPelicula(pelicula);

        // Eliminar una película
        peliculaDAO.eliminarPelicula(1);
    }
}
