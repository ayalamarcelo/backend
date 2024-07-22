package org.application.services;

import org.application.adapters.IRepository;
import org.domain.models.Movie;
import org.infrastructure.database.MySQLRepositoryImpl;

public class MovieService implements IRepository {

    private final IRepository repository = new MySQLRepositoryImpl();

    @Override
    public void saveMovie(Movie movie) {
        repository.saveMovie(movie);
    }

    @Override
    public Movie findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public void deleteMovie(int id) {
        repository.deleteMovie(id);
    }

    @Override
    public boolean updateMovie(Movie movie) {
        repository.updateMovie(movie);
        return true;
    }
}
