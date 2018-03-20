package com.vincentcarrier.repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MoviesRepo {
    private TheMovieDbApi service;

    @Inject public MoviesRepo(TheMovieDbApi service) {
        this.service = service;
    }

    public Observable<MovieResults> getMovies(MovieSortMethod sortMethod, int page) {
        return service.getMovies(sortMethod.jsonName, page);
//                .map({ (MovieResults) response -> response.results() });
    }
}
