package com.twu.biblioteca.entity;

public class Movie {
    private long movieId;
    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(long movieId, String name, String year, String director, String rating) {
        this.movieId = movieId;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

