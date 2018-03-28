package com.vincentcarrier.repository;

public enum MovieSortMethod {
    TOP_RATED("top_rated"), POPULAR("popular");

    public final String pathString;

    MovieSortMethod(String pathString) {
        this.pathString = pathString;
    }
}
