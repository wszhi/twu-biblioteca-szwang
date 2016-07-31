package com.twu.biblioteca.entity;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class OptionsTest {
    Options options;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @Before
    public void setUp() throws Exception {
        options = new Options();
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void shouldPrintListBooksMenu() throws Exception {
        options.createMenu();
        String menu = "List Books";
        assertTrue(bytes.toString().contains(menu));
    }
}