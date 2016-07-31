package com.twu.biblioteca;


import com.twu.biblioteca.entity.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieActionTest {
    MovieAction movieAction;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @Before
    public void setUp() throws Exception {
        movieAction = new MovieAction();
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void shouldShowMovieInfoWhenShowList() throws Exception {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(1, "Movie1", "2012", "director1",1));
        movieAction.showMovieList(movieList);
        assertTrue(bytes.toString().contains("Movie1"));
        assertTrue(bytes.toString().contains("director1"));
        assertTrue(bytes.toString().contains("2012"));
    }

    @Test
    public void shouldShowSuccessMessageWhenMovieIsValid() throws Exception {
        Movie movie = new Movie(1, "Movie1", "2012", "director1",1);
        movieAction.checkOutAMovie(String.valueOf(movie.getMovieId()));
        assertFalse(movieAction.getMovieList().contains(movie));
        assertTrue(bytes.toString().contains("Thank you! Enjoy the movie"));
    }

    @Test
    public void shouldShowFailMessageWhenMovieIsInvalid() throws Exception {
        Movie movie = new Movie(1, "Movie1", "2012", "director1",1);
        movieAction.checkOutAMovie(String.valueOf("7"));
        assertThat(movieAction.getMovieList().size(), is(6));
        assertTrue(bytes.toString().contains("That movie is not available."));
    }

    @Test
    public void shouldShowSuccessfulMessageWhenReturnMovieSuccess() throws Exception {
        Movie movie = new Movie(1, "Movie1", "2012", "director1",1);
        movieAction.checkOutAMovie(String.valueOf(movie.getMovieId()));
        assertThat(movieAction.getCheckOutMovies().size(), is(1));
        assertEquals(1L, movieAction.getCheckOutMovies().get(0).getMovieId());

        movieAction.returnMovie(String.valueOf(movie.getMovieId()));
        assertFalse(movieAction.getCheckOutMovies().contains(movie));
        assertTrue(bytes.toString().contains("Thank you for returning the movie."));
    }

    @Test
    public void shouldShowFailMessageWhenReturnMovieFail() throws Exception {
        Movie movie = new Movie(7, "Movie7", "2012", "director7",1);

        movieAction.returnMovie(String.valueOf(movie.getMovieId()));
        assertTrue(bytes.toString().contains("That is not a valid movie to return"));
    }
}