package filmoteca.persistencia;

import java.util.ArrayList;

public interface IPersistencia {

        void guardarPeliculas(ArrayList<Pelicula> peliculas);
        ArrayList<Pelicula> traerPeliculas();
        void actualizarPelicula(String directorNuevo, int anio);
        void borrarPelicula(int id);
}
