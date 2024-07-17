package org.application.services;

import org.application.adapters.IRepository;
import org.domain.models.Pelicula;
import org.infrastructure.database.MySQLRepositoryImpl;

public class PeliculaService implements IRepository {

    private final IRepository repository = new MySQLRepositoryImpl();

    @Override
    public void savePelicula(Pelicula pelicula) {
        repository.savePelicula(pelicula);
    }

    @Override
    public Pelicula findByTitulo(String titulo) {
        return repository.findByTitulo(titulo);
    }

    @Override
    public void deletePelicula(int id) {
        repository.deletePelicula(id);
    }

    @Override
    public boolean updatePelicula(Pelicula pelicula) {
        repository.updatePelicula(pelicula);
        return false;
    }
}
