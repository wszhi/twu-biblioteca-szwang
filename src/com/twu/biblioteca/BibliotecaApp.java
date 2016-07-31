package com.twu.biblioteca;

import com.twu.biblioteca.entity.Constants;
import com.twu.biblioteca.entity.Options;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println(Constants.WELCOME);
        System.out.println(Constants.TIPS);
        new Options().createMenu();
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            String menuId = reader.next();
            switch (menuId) {
                case "1":
                    new ShowBookList().showBookList();
                    break;
                default:
                    System.out.println(Constants.INVALIDMSG);
                    break;
            }
        }

    }


}
