package com.vincentcarrier.repository;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue public abstract class Movie {
	abstract int id();
	abstract String title();
	@Json(name = "poster_path") abstract String posterPath();
	@Json(name = "release_date") abstract String releaseDate();
	@Json(name = "vote_average") abstract double voteAverage();

	static Movie create(int id, String title, String posterPath, String releaseDate,
	                             double voteAverage) {
		return new AutoValue_Movie(id, title, posterPath, releaseDate, voteAverage);
	}

    public static JsonAdapter<Movie> jsonAdapter(Moshi moshi) {
        return new AutoValue_Movie.MoshiJsonAdapter(moshi);
    }
}

