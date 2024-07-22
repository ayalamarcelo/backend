package org.application.adapters;

import org.domain.models.Movie;

public interface IRepository {

    void saveMovie(Movie movie);
    Movie findByTitle(String title);
    void deleteMovie(int id);
    boolean updateMovie(Movie movie);
}
