package org.application.adapters;

import org.domain.models.Pelicula;
import org.infrastructure.controllers.PeliculaController;

public interface IRepository {

    void savePelicula(Pelicula pelicula);
    Pelicula findByTitulo(String titulo);
    void deletePelicula(int id);
    boolean updatePelicula(Pelicula pelicula);
}
