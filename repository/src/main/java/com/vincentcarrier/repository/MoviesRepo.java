package com.vincentcarrier.repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

class MoviesRepo {
    private TheMovieDbApi service;

    @Inject public MoviesRepo(TheMovieDbApi service) {
        this.service = service;
    }

    public Observable<List<Movie>> getMovies(MovieSortMethod sortMethod, int page) {
        return service.getMovies(sortMethod.jsonName, page);
    }
}
