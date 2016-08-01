package com.twu.biblioteca.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class OptionsTest {
    Options options;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @Before
    public void setUp() throws Exception {
        options = new Options(1.1, "List Books");
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void shouldPrintOptionsInConsole() throws Exception {
        List<Options> optionsList = new ArrayList<Options>();
        optionsList.add(options);
        options.createMenu(optionsList);
        assertTrue(bytes.toString().contains(options.getMenuName()));

    }
}