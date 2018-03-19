package com.vincentcarrier.repository;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface TheMovieDbApi {
    @GET("movie/{sort_method}")
    Observable<List<Movie>> getMovies(@Path("sort_method") String sortMethod,
                                      @Query("page") int page);
}
