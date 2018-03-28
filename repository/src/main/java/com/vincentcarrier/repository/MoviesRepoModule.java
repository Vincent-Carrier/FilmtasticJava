package com.vincentcarrier.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = TheMovieDbServiceModule.class)
public class MoviesRepoModule {
	@Provides
	@Singleton
	static MoviesRepo moviesRepo(TheMovieDbApi api) {
		return new MoviesRepo(api);
	}
}
