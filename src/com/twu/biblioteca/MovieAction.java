package com.twu.biblioteca;

import com.twu.biblioteca.entity.Constants;
import com.twu.biblioteca.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAction {
    private List<Movie> movieList = new ArrayList<>();
    private List<Movie> checkOutMovies = new ArrayList<>();
    FormatPrint formatPrint = new FormatPrint();

    public MovieAction() {
        this.movieList.add(new Movie(1, "Movie1", "2012", "director1", 1));
        this.movieList.add(new Movie(2, "Movie2", "2012", "director2", 2));
        this.movieList.add(new Movie(3, "Movie3", "2013", "director3", 4));
        this.movieList.add(new Movie(4, "Movie4", "2011", "director4", 7));
        this.movieList.add(new Movie(5, "Movie5", "2016", "director5", 9));
        this.movieList.add(new Movie(6, "Movie6", "2015", "director6", 3));
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public List<Movie> getCheckOutMovies() {
        return checkOutMovies;
    }

    public void showMovieList(List<Movie> movies) {
        formatPrint.drawLine();
        System.out.println(formatPrint.formatShortString(Constants.ID)
                + formatPrint.formatString(Constants.MOVIENAME)
                + formatPrint.formatString(Constants.DIRECTOR)
                + formatPrint.formatString(Constants.YEAR)
                + formatPrint.formatString(Constants.RATING));
        formatPrint.drawLine();
        for (Movie movie : movies) {
            System.out.println(formatPrint.formatShortString(String.valueOf(movie.getMovieId()))
                    + formatPrint.formatString(movie.getName())
                    + formatPrint.formatString(movie.getDirector())
                    + formatPrint.formatString(movie.getYear())
                    + formatPrint.formatString(String.valueOf(movie.getRating())));
        }
        formatPrint.drawLine();
    }

    public void checkOutAMovie(String movieId) {
        Boolean exitsMovie = false;
        for (Movie movie : movieList) {
            if (String.valueOf(movie.getMovieId()).equals(movieId)) {
                movieList.remove(movie);
                checkOutMovies.add(movie);
                exitsMovie = true;
                break;
            }
        }
        if (exitsMovie) {
            System.out.println(Constants.CHECKOUTMOVIESUCCESSMSG);
        } else {
            System.out.println(Constants.CHECKOUTMOVIEFAILMSG);
        }
    }

    public void returnMovie(String movieId) {
        Boolean validReturnMovie = false;
        for (Movie movie : checkOutMovies) {
            if (String.valueOf(movie.getMovieId()).equals(movieId)) {
                movieList.add(movie);
                checkOutMovies.remove(movie);
                validReturnMovie = true;
                break;
            }
        }
        if (validReturnMovie) {
            System.out.println(Constants.RETURNMOVIESUCCESS);
        } else {
            System.out.println(Constants.RETURNMOVIEFAIL);
        }
    }
}
