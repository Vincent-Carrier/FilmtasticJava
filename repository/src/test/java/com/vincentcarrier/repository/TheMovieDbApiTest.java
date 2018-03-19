package com.vincentcarrier.repository;

import org.junit.Test;
import java.util.List;

import retrofit2.Retrofit;

import static org.assertj.core.api.Assertions.*;

import static com.vincentcarrier.repository.MovieSortMethod.POPULAR;

public class TheMovieDbApiTest {
    RetrofitModule m = new RetrofitModule();
    Retrofit retrofit = m.retrofit(m.client(m.apiKeyInterceptor()));
    MoviesRepo repo = new MoviesRepo(retrofit.create(TheMovieDbApi.class));

    MovieResults movies = repo.getMovies(POPULAR, 1).blockingFirst();

    @Test public void should_return_movies() {
        assertThat(movies.results()).isNotEmpty();
    }
}