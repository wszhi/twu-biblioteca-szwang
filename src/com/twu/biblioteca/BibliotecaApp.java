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
        System.out.println(Constants.INPUTLIBRARYNUM);
        String libraryNumber = reader.next();
        System.out.println(Constants.INPUTPASSWORD);
        String password = reader.next();
        Users currentUser = userAction.loginAction(libraryNumber, password);
        if (currentUser != null) {
            saveOrUpdateUserCheckInfo(currentUser);
            boolean isLibrarian = currentUser.getType().equals("librarian") ? true : false;
            choseTheSecondMenu(isLibrarian, false);
        } else {
            System.out.println(Constants.LOGINFAIL);
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

    private static void choseTheSecondMenu(boolean isLibrarian, Boolean isCheckOutList) {
        createTheSecondMenu(isLibrarian);
        while (reader.hasNext()) {
            String menuId = reader.next();
            List<BookInfo> bookInfoList = new ArrayList<>();
            List<Movie> movieList = new ArrayList<>();
            switch (menuId) {
                case "2.0":
                    showUserInformation();
                    break;
                case "2.1":
                    bookAction.showBookList(bookAction.getBookInfoList());
                    break;
                case "2.2":
                    System.out.print(Constants.CHECKOUTTIPS);
                    checkOutBook(bookInfoList, reader.next());
                    break;
                case "2.3":
                    System.out.print(Constants.RETURNBOOKTIPS);
                    returnBook(bookInfoList, reader.next());
                    break;
                case "2.4":
                    movieAction.showMovieList(movieAction.getMovieList());
                    break;
                case "2.5":
                    System.out.print(Constants.CHECKOUTMOVIETIPS);
                    checkOutMovie(movieList, reader.next());
                    break;
                case "2.6":
                    System.out.print(Constants.RETURNMOVIETIPS);
                    returnMovie(movieList, reader.next());
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
                case "3.1":
                    showAllCheckOutBookInfo(isLibrarian);
                    break;
                case "3.2":
                    showAllCheckOutMovieInfo(isLibrarian);
                    break;
                default:
                    System.out.println(Constants.INVALIDMSG);
                    break;
            }
        }
    }

    private static void showAllCheckOutMovieInfo(boolean isLibrarian) {
        if (isLibrarian) {
            for (UserCheckOut userCheckOut : userCheckOutList) {
                if (!userCheckOut.getUsers().getType().equals("librarian")) {
                    System.out.println("customer: " + userCheckOut.getUsers().getName()
                            + "            phone number: " + userCheckOut.getUsers().getPhoneNumber()
                            + "            email: " + userCheckOut.getUsers().getEmail());
                    movieAction.showMovieList(userCheckOut.getUserMovieList());
                }
            }
        }
    }

    public static void showAllCheckOutBookInfo(boolean isLibrarian) {
        if (isLibrarian) {
            for (UserCheckOut userCheckOut : userCheckOutList) {
                if (!userCheckOut.getUsers().getType().equals("librarian")) {
                    System.out.println("customer: " + userCheckOut.getUsers().getName()
                            + "            phone number: " + userCheckOut.getUsers().getPhoneNumber()
                            + "            email: " + userCheckOut.getUsers().getEmail());
                    bookAction.showBookList(userCheckOut.getUserBookInfoList());
                }
            }
        }
    }

    private static void showUserInformation() {
        Users users = userCheckOutList.get(positionOfCurrentUser).getUsers();
        System.out.println("User's Library Number: " + users.getLibraryNumber());
        System.out.println("User's Name: " + users.getName());
        System.out.println("User's Email: " + users.getEmail());
        System.out.println("User's Address: " + users.getAddress());
        System.out.println("User's Phone Number: " + users.getPhoneNumber());
    }

    public static void returnBook(List<BookInfo> bookInfoList, String bookId) {
        bookInfoList.clear();
        bookInfoList = userCheckOutList.get(positionOfCurrentUser).getUserBookInfoList();
        bookInfoList.remove(bookAction.returnBook(bookId));
        userCheckOutList.get(positionOfCurrentUser).setUserBookInfoList(bookInfoList);
    }

    public static void checkOutBook(List<BookInfo> bookInfoList, String bookId) {
        bookInfoList.clear();
        bookInfoList = userCheckOutList.get(positionOfCurrentUser).getUserBookInfoList();
        bookInfoList.add(bookAction.checkOutABook(bookId));
        userCheckOutList.get(positionOfCurrentUser).setUserBookInfoList(bookInfoList);
    }

    public static void returnMovie(List<Movie> movieList, String movieId) {
        movieList.clear();
        movieList = userCheckOutList.get(positionOfCurrentUser).getUserMovieList();
        movieList.remove(movieAction.returnMovie(movieId));
        userCheckOutList.get(positionOfCurrentUser).setUserMovieList(movieList);
    }

    public static void checkOutMovie(List<Movie> movieList, String movieId) {
        movieList.clear();
        movieList = userCheckOutList.get(positionOfCurrentUser).getUserMovieList();
        movieList.add(movieAction.checkOutAMovie(movieId));
        userCheckOutList.get(positionOfCurrentUser).setUserMovieList(movieList);
    }

    public static void createTheSecondMenu(boolean isLibrarian) {
        List<Options> optionsList = new ArrayList<>();
        optionsList.add(new Options(2.0, Constants.USERINFOR));
        optionsList.add(new Options(2.1, Constants.LISTBOOKS));
        optionsList.add(new Options(2.4, Constants.LISTMOVIES));
        optionsList.add(new Options(2.9, Constants.LOGOUT));
        new Options().createMenuWithOutBottomLine(optionsList);

        if (!isLibrarian) {
            optionsList.clear();
            optionsList.add(new Options(2.2, Constants.CHECKOUTBOOKS));
            optionsList.add(new Options(2.3, Constants.RETURNBOOK));
            optionsList.add(new Options(2.5, Constants.CHECKOUTMOVIE));
            optionsList.add(new Options(2.6, Constants.RETURNMOVIE));
            new Options().createMenuWithOutBottomLine(optionsList);
            optionsList.clear();
            optionsList.add(new Options(2.7, Constants.SEEMYCHECKOUTBOOKS));
            optionsList.add(new Options(2.8, Constants.SEEMYCHECKOUTMOVIES));
            new Options().createMenu(optionsList);
        } else {
            optionsList.clear();
            optionsList.add(new Options(3.1, Constants.ALLCHECKOUTBOOKS));
            optionsList.add(new Options(3.2, Constants.ALLCHECKOUTMOVIES));
            new Options().createMenu(optionsList);
        }
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
