package com.twu.biblioteca;

import com.twu.biblioteca.entity.Constants;
import com.twu.biblioteca.entity.Options;
import com.twu.biblioteca.entity.UserCheckOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        BookAction bookAction = new BookAction();
        MovieAction movieAction = new MovieAction();
        UserAction userAction = new UserAction();
        List<UserCheckOut> userCheckOutList = new ArrayList<>();

        System.out.println(Constants.WELCOME);
        System.out.println(Constants.TIPS);
        createTheFirstMenu();
        choseTheFirstMenu(bookAction, movieAction, userAction);

    }

    private static void choseTheFirstMenu(BookAction bookAction, MovieAction movieAction, UserAction userAction) {

        while (reader.hasNext()) {
            String menuId = reader.next();
            switch (menuId) {
                case "1.1":
                    loginAction(bookAction, movieAction, userAction);
                    break;
                case "1.2":
                    bookAction.showBookList(bookAction.getBookInfoList());
                    break;
                case "1.3":
                    movieAction.showMovieList(movieAction.getMovieList());
                    break;
                case "1.9":
                    return;
                default:
                    System.out.println(Constants.INVALIDMSG);
                    break;
            }
        }
    }

    private static void loginAction(BookAction bookAction, MovieAction movieAction, UserAction userAction) {
        System.out.println("Please input the library number:");
        String libraryNumber = reader.next();
        System.out.println("Please input the password:");
        String password = reader.next();
        if (userAction.loginAction(libraryNumber, password)) {
            createMenu();
            choseTheSecondMenu(bookAction, movieAction);
        }
        System.out.println("Login Fail !!!!");
    }

    private static void choseTheSecondMenu(BookAction bookAction, MovieAction movieAction) {
        while (reader.hasNext()) {
            String menuId = reader.next();
            switch (menuId) {
                case "2.1":
                    bookAction.showBookList(bookAction.getBookInfoList());
                    break;
                case "2.2":
                    System.out.print(Constants.CHECKOUTTIPS);
                    bookAction.checkOutABook(reader.next());
                    break;
                case "2.3":
                    System.out.print(Constants.RETURNBOOKTIPS);
                    bookAction.returnBook(reader.next());
                    break;
                case "2.4":
                    movieAction.showMovieList(movieAction.getMovieList());
                    break;
                case "2.5":
                    System.out.print(Constants.CHECKOUTMOVIETIPS);
                    movieAction.checkOutAMovie(reader.next());
                    break;
                case "2.6":
                    System.out.print(Constants.RETURNMOVIETIPS);
                    movieAction.returnMovie(reader.next());
                    break;
                case "2.9":
                    return;
                default:
                    System.out.println(Constants.INVALIDMSG);
                    break;
            }
        }
    }

    public static void createMenu() {
        List<Options> optionsList = new ArrayList<>();
        optionsList.add(new Options(2.1, Constants.LISTBOOKS));
        optionsList.add(new Options(2.1, Constants.CHECKOUTBOOKS));
        optionsList.add(new Options(2.3, Constants.RETURNBOOK));
        optionsList.add(new Options(2.4, Constants.LISTMOVIES));
        optionsList.add(new Options(2.5, Constants.CHECKOUTMOVIE));
        optionsList.add(new Options(2.6, Constants.RETURNMOVIE));
        optionsList.add(new Options(2.9, Constants.QUIT));
        new Options().createMenu(optionsList);
    }

    public static void createTheFirstMenu() {
        List<Options> optionsList = new ArrayList<>();
        optionsList.add(new Options(1.1, Constants.LOGIN));
        optionsList.add(new Options(1.2, Constants.LISTBOOKS));
        optionsList.add(new Options(1.3, Constants.LISTMOVIES));
        optionsList.add(new Options(1.9, Constants.QUIT));
        new Options().createMenu(optionsList);
    }

}
