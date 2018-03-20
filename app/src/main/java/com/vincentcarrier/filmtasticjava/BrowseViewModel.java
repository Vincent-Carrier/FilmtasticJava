package com.vincentcarrier.filmtasticjava;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.vincentcarrier.repository.Movie;
import com.vincentcarrier.repository.MoviesRepo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

class BrowseViewModel extends ViewModel {
    @Inject private MoviesRepo repo;

    private List<Movie> movies = new ArrayList<>();

    public BrowseViewModel(MoviesRepo repo) {
        this.repo = repo;
    }


}

class BrowseViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @Inject MoviesRepo repo;

    @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BrowseViewModel(repo);
    }
}