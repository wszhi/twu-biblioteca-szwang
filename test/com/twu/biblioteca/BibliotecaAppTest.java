package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaAppTest {
    BibliotecaApp bibliotecaApp;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @Before
    public void setUp() throws Exception {
        bibliotecaApp = new BibliotecaApp();
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void shouldShowWelcomeMessage() throws Exception {
    }

}