package com.vincentcarrier.filmtasticjava;

import android.arch.lifecycle.ViewModel;

import com.vincentcarrier.filmtasticjava.di.DaggerAppComponent;
import com.vincentcarrier.repository.Movie;
import com.vincentcarrier.repository.MovieSortMethod;
import com.vincentcarrier.repository.MoviesRepo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

import static com.vincentcarrier.repository.MovieSortMethod.POPULAR;

class BrowseViewModel extends ViewModel {
	@Inject
	public MoviesRepo repo;

	private List<Movie> movies = new ArrayList<>();

	private MovieSortMethod sortMethod = POPULAR;

	public BrowseViewModel() {
		DaggerAppComponent.create().inject(this);
	}

	Observable<List<Movie>> getMovies() {
		return repo.getMovies(sortMethod, 1)
				.doOnNext(fetchedMovies ->
					movies = fetchedMovies
				);
	}
}