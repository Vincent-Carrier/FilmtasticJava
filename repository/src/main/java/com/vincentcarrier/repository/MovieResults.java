package com.vincentcarrier.repository;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
abstract class MovieResults {
    abstract List<Movie> results();

    static MovieResults create(List<Movie> results) {
        return new AutoValue_MovieResults(results);
    }

    public static JsonAdapter<MovieResults> jsonAdapter(Moshi moshi) {
        return new AutoValue_MovieResults.MoshiJsonAdapter(moshi);
    }
}
