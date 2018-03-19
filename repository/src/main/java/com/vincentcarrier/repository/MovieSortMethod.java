package com.vincentcarrier.repository;

public enum MovieSortMethod {
    TOP_RATED("top_rated"), POPULAR("popular");

    public final String jsonName;

    MovieSortMethod(String jsonName) {
        this.jsonName = jsonName;
    }
}
