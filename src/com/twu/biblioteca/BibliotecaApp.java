package com.twu.biblioteca;

import com.twu.biblioteca.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    static BookAction bookAction = new BookAction();
    static MovieAction movieAction = new MovieAction();
    static UserAction userAction = new UserAction();

    static Scanner reader = new Scanner(System.in);
    static List<UserCheckOut> userCheckOutList = new ArrayList<>();
    static int positionOfCurrentUser = -1;


    public static void main(String[] args) {

        System.out.println(Constants.WELCOME);
        System.out.println(Constants.TIPS);
        choseTheFirstMenu();

    }

    private static void choseTheFirstMenu() {
        createTheFirstMenu();
        while (reader.hasNext()) {
            String menuId = reader.next();
            switch (menuId) {
                case "1.1":
                    loginAction();
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

    private static void loginAction() {
        System.out.println("Please input the library number:");
        String libraryNumber = reader.next();
        System.out.println("Please input the password:");
        String password = reader.next();
        Users currentUser = userAction.loginAction(libraryNumber, password);
        if (currentUser != null) {
            saveOrUpdateUserCheckInfo(currentUser);
            choseTheSecondMenu();
        } else {
            System.out.println("Login Fail !!!!");
        }
    }

    private static void saveOrUpdateUserCheckInfo(Users currentUser) {
        for (int position = 0; position < userCheckOutList.size(); position++) {
            if (userCheckOutList.get(position).getUsers().equals(currentUser)) {
                positionOfCurrentUser = position;
                break;
            } else {
                positionOfCurrentUser = -1;
            }
        }
        if (positionOfCurrentUser == -1) {
            positionOfCurrentUser = userCheckOutList.size();
            UserCheckOut userCheckOut = new UserCheckOut(currentUser, new ArrayList<Movie>(), new ArrayList<BookInfo>());
            userCheckOutList.add(userCheckOut);
        }
    }

    private static void choseTheSecondMenu() {
        createTheSecondMenu();
        while (reader.hasNext()) {
            String menuId = reader.next();
            List<BookInfo> bookInfoList = new ArrayList<>();
            List<Movie> movieList = new ArrayList<>();
            switch (menuId) {
                case "2.1":
                    bookAction.showBookList(bookAction.getBookInfoList());
                    break;
                case "2.2":
                    System.out.print(Constants.CHECKOUTTIPS);
                    checkOutBook(bookInfoList);
                    break;
                case "2.3":
                    System.out.print(Constants.RETURNBOOKTIPS);
                    returnBook(bookInfoList);
                    break;
                case "2.4":
                    movieAction.showMovieList(movieAction.getMovieList());
                    break;
                case "2.5":
                    System.out.print(Constants.CHECKOUTMOVIETIPS);
                    checkOutMovie(movieList);
                    break;
                case "2.6":
                    System.out.print(Constants.RETURNMOVIETIPS);
                    returnMovie(movieList);
                    break;
                case "2.7":
                    bookAction.showBookList(userCheckOutList.get(positionOfCurrentUser).getUserBookInfoList());
                    break;
                case "2.8":
                    movieAction.showMovieList(userCheckOutList.get(positionOfCurrentUser).getUserMovieList());
                    break;
                case "2.9":
                    choseTheFirstMenu();
                    return;
                default:
                    System.out.println(Constants.INVALIDMSG);
                    break;
            }
        }
    }

    private static void returnBook(List<BookInfo> bookInfoList) {
        bookInfoList.clear();
        bookInfoList = userCheckOutList.get(positionOfCurrentUser).getUserBookInfoList();
        bookInfoList.remove(bookAction.returnBook(reader.next()));
        userCheckOutList.get(positionOfCurrentUser).setUserBookInfoList(bookInfoList);
    }

    private static void checkOutBook(List<BookInfo> bookInfoList) {
        bookInfoList.clear();
        bookInfoList = userCheckOutList.get(positionOfCurrentUser).getUserBookInfoList();
        bookInfoList.add(bookAction.checkOutABook(reader.next()));
        userCheckOutList.get(positionOfCurrentUser).setUserBookInfoList(bookInfoList);
    }

    private static void returnMovie(List<Movie> movieList) {
        movieList.clear();
        movieList = userCheckOutList.get(positionOfCurrentUser).getUserMovieList();
        movieList.remove(movieAction.returnMovie(reader.next()));
        userCheckOutList.get(positionOfCurrentUser).setUserMovieList(movieList);
    }

    private static void checkOutMovie(List<Movie> movieList) {
        movieList.clear();
        movieList = userCheckOutList.get(positionOfCurrentUser).getUserMovieList();
        movieList.add(movieAction.checkOutAMovie(reader.next()));
        userCheckOutList.get(positionOfCurrentUser).setUserMovieList(movieList);
    }

    public static void createTheSecondMenu() {
        List<Options> optionsList = new ArrayList<>();
        optionsList.add(new Options(2.1, Constants.LISTBOOKS));
        optionsList.add(new Options(2.2, Constants.CHECKOUTBOOKS));
        optionsList.add(new Options(2.3, Constants.RETURNBOOK));
        optionsList.add(new Options(2.4, Constants.LISTMOVIES));
        optionsList.add(new Options(2.5, Constants.CHECKOUTMOVIE));
        optionsList.add(new Options(2.6, Constants.RETURNMOVIE));
        optionsList.add(new Options(2.7, Constants.SEEMYCHECKOUTBOOKS));
        optionsList.add(new Options(2.8, Constants.SEEMYCHECKOUTMOVIES));
        optionsList.add(new Options(2.9, Constants.LOGOUT));
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
