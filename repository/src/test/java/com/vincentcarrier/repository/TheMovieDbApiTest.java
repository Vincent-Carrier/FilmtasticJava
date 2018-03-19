package com.vincentcarrier.repository;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

import static org.assertj.core.api.Assertions.*;

import static com.vincentcarrier.repository.MovieSortMethod.POPULAR;

public class TheMovieDbApiTest {
    @Inject public MoviesRepo repo;

    @Before public void setUp() {
        Scope scope = Toothpick.openScope(this);
        scope.installModules(new RetrofitModule());
        Toothpick.inject(this, scope);
    }

    List<Movie> movies = repo.getMovies(POPULAR, 1).blockingFirst();

    @Test public void should_return_movies() {
        assertThat(movies).isNotEmpty();
    }
}