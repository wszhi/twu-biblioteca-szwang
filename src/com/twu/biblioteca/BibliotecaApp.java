package com.twu.biblioteca;

import com.twu.biblioteca.entity.Constants;
import com.twu.biblioteca.entity.Options;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookAction bookAction = new BookAction();
        MovieAction movieAction = new MovieAction();
        System.out.println(Constants.WELCOME);
        System.out.println(Constants.TIPS);
        createMenu();
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            String menuId = reader.next();
            switch (menuId) {
                case "1":
                    bookAction.showBookList(bookAction.getBookInfoList());
                    break;
                case "2":
                    System.out.print(Constants.CHECKOUTTIPS);
                    bookAction.checkOutABook(reader.next());
                    break;
                case "3":
                    System.out.print(Constants.RETURNBOOKTIPS);
                    bookAction.returnBook(reader.next());
                    break;
                case "4":
                    movieAction.showMovieList(movieAction.getMovieList());
                    break;
                case "5":
                    System.out.print(Constants.CHECKOUTMOVIETIPS);
                    movieAction.checkOutAMovie(reader.next());
                    break;
                case "6":
                    System.out.print(Constants.RETURNMOVIETIPS);
                    movieAction.returnMovie(reader.next());
                    break;
                case "9":
                    return;
                default:
                    System.out.println(Constants.INVALIDMSG);
                    break;
            }
        }

    }

    public static void createMenu() {
        List<Options> optionsList = new ArrayList<>();
        optionsList.add(new Options(1, Constants.LISTBOOKS));
        optionsList.add(new Options(2, Constants.CHECKOUTBOOKS));
        optionsList.add(new Options(3, Constants.RETURNBOOK));
        optionsList.add(new Options(4, Constants.LISTMOVIES));
        optionsList.add(new Options(5, Constants.CHECKOUTMOVIE));
        optionsList.add(new Options(6, Constants.RETURNMOVIE));
        optionsList.add(new Options(9, Constants.QUIT));
        new Options().createMenu(optionsList);
    }

}
