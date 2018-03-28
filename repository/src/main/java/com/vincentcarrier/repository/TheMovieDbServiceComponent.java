package com.vincentcarrier.repository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TheMovieDbServiceModule.class)
public interface TheMovieDbServiceComponent {
	TheMovieDbApi service();
}
