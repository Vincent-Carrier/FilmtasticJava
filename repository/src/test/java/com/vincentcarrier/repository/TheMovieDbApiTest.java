package com.vincentcarrier.repository;

import org.junit.Test;

import static com.vincentcarrier.repository.MovieSortMethod.POPULAR;
import static org.assertj.core.api.Assertions.assertThat;

public class TheMovieDbApiTest {
	TheMovieDbApi api = DaggerTheMovieDbServiceComponent.builder().build().service();
	MoviesRepo repo = new MoviesRepo(api);

	MovieResults movies = repo.getMovies(POPULAR, 1).blockingFirst();

	@Test
	public void should_return_movies() {
		assertThat(movies.results()).isNotEmpty();
	}
}