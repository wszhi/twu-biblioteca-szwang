package com.twu.biblioteca;

import com.twu.biblioteca.entity.BookInfo;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.UserCheckOut;
import com.twu.biblioteca.entity.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.userCheckOutList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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
    public void showCorrectMenuIfLibrarianLogin() throws Exception {
        bibliotecaApp.createTheSecondMenu(true);
        String menu1 = "User Information";
        String menu2 = "List Books";
        String menu3 = "List Movies";
        String menu4 = "Log Out";
        assertTrue(bytes.toString().contains(menu1));
        assertTrue(bytes.toString().contains(menu2));
        assertTrue(bytes.toString().contains(menu3));
        assertTrue(bytes.toString().contains(menu4));

        assertTrue(bytes.toString().contains("See All Check Out Books"));
        assertTrue(bytes.toString().contains("See All Check Out Movies"));
    }

    @Test
    public void showCorrectMenuIfCustomerLogin() throws Exception {
        bibliotecaApp.createTheSecondMenu(false);
        String menu1 = "User Information";
        String menu2 = "List Books";
        String menu3 = "List Movies";
        String menu4 = "Log Out";
        assertTrue(bytes.toString().contains(menu1));
        assertTrue(bytes.toString().contains(menu2));
        assertTrue(bytes.toString().contains(menu3));
        assertTrue(bytes.toString().contains(menu4));

        assertTrue(bytes.toString().contains("See My CHeck Out Movies"));
        assertTrue(bytes.toString().contains("See My Check Out Books"));

    }

    @Test
    public void showMenuListWithoutLogin() throws Exception {
        bibliotecaApp.createTheFirstMenu();
        String menu1 = "Login";
        String menu2 = "List Books";
        String menu3 = "List Movies";
        String menu4 = "Quit";
        assertTrue(bytes.toString().contains(menu1));
        assertTrue(bytes.toString().contains(menu2));
        assertTrue(bytes.toString().contains(menu3));
        assertTrue(bytes.toString().contains(menu4));
        assertFalse(bytes.toString().contains("Check Out Book"));
    }

    @Test
    public void shouldAddOrRemoveMovieInListWhenCheckOutOrReturn() throws Exception {
        createDataForTest();
        bibliotecaApp.checkOutMovie(new ArrayList<Movie>(), "1");
        assertThat(userCheckOutList.size(), is(1));
        assertThat(userCheckOutList.get(0).getUserMovieList().get(0).getMovieId(), is(1L));

        bibliotecaApp.returnMovie(new ArrayList<Movie>(), "1");
        assertThat(userCheckOutList.size(), is(1));
        assertThat(userCheckOutList.get(0).getUserMovieList().size(), is(0));
    }

    private void createDataForTest() {
        deleteDataForTest();
        UserCheckOut userCheckOut = new UserCheckOut();
        userCheckOut.setUserMovieList(new ArrayList<Movie>());
        userCheckOut.setUserBookInfoList(new ArrayList<BookInfo>());
        userCheckOutList = new ArrayList<>();
        userCheckOutList.add(userCheckOut);
        bibliotecaApp.positionOfCurrentUser = 0;
    }

    private void deleteDataForTest() {

        bibliotecaApp.userCheckOutList = new ArrayList<>();
        bibliotecaApp.positionOfCurrentUser = -1;
    }

    @Test
    public void shouldAddOrRemoveBookInListWhenCheckOutOrReturn() throws Exception {
        createDataForTest();
        bibliotecaApp.checkOutBook(new ArrayList<BookInfo>(), "1");
        assertThat(userCheckOutList.size(), is(1));
        assertThat(userCheckOutList.get(0).getUserBookInfoList().get(0).getBookId(), is(1L));

        bibliotecaApp.returnBook(new ArrayList<BookInfo>(), "1");
        assertThat(userCheckOutList.size(), is(1));
        assertThat(userCheckOutList.get(0).getUserBookInfoList().size(), is(0));
    }

    @Test
    public void shouldShowCustomerUserCheckOutInfoWhenLibrarianLogin() throws Exception {
        createDataForTest();
        userCheckOutList.get(0).setUsers(new Users("111-1111", "123456", "customer", "Tom", "tom@gmail.com", "China", "13411200926"));
        bibliotecaApp.showAllCheckOutBookInfo(true);
        assertTrue(bytes.toString().contains("customer"));
    }

    @Test
    public void shouldNotShowLibrarianUserInfoWhenLibrarianLogin() throws Exception {
        createDataForTest();
        userCheckOutList.get(0).setUsers(new Users("111-1111", "123456", "librarian", "Tom", "tom@gmail.com", "China", "13411200926"));
        bibliotecaApp.showAllCheckOutBookInfo(false);
        assertFalse(bytes.toString().contains("customer"));
    }

    @Test
    public void shouldNotShowUserCheckOutInfoWhenCustomerLogin() throws Exception {
        createDataForTest();
        userCheckOutList.get(0).setUsers(new Users("111-1111", "123456", "customer", "Tom", "tom@gmail.com", "China", "13411200926"));
        bibliotecaApp.showAllCheckOutBookInfo(false);
        assertFalse(bytes.toString().contains("customer"));
    }


}