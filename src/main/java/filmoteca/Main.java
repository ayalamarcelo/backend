package filmoteca;

import filmoteca.database.DatabaseInitializer;
import filmoteca.database.PeliculaDAO;
import filmoteca.domain.models.Pelicula;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.initializeDatabase();
        var peliculaDAO = new PeliculaDAO();

        // Crear una nueva película
        var nuevaPelicula = new Pelicula("Inception", "Christopher Nolan", 2010, "Sci-Fi");
        peliculaDAO.crearPelicula(nuevaPelicula);

        // Leer una película por id
        var pelicula = peliculaDAO.leerPelicula(1);
        if (pelicula != null) {
            System.out.println("Leer Película: " + pelicula.getTitulo());
        }

        // Leer todas las películas
        var peliculas = peliculaDAO.leerTodasLasPeliculas();
        peliculas.forEach(p -> System.out.println("Película: " + p.getTitulo()));

        // Actualizar una película
        pelicula.setTitulo("Inception Updated");
        peliculaDAO.actualizarPelicula(pelicula);

        // Eliminar una película
        peliculaDAO.eliminarPelicula(2);
    }
}
