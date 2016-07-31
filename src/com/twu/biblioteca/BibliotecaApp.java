package com.twu.biblioteca;

import com.twu.biblioteca.entity.Constants;
import com.twu.biblioteca.entity.Options;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println(Constants.WELCOME);
        System.out.println(Constants.TIPS);
        createMenu();
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            String menuId = reader.next();
            switch (menuId) {
                case "1":
                    new ShowBookList().showBookList();
                    break;
                case "9":
                    return;
                default:
                    System.out.println(Constants.INVALIDMSG);
                    break;
            }
        }

    }

    public static void createMenu(){
        List<Options> optionsList=new ArrayList<>();
        optionsList.add(new Options(1, Constants.LISTBOOKS));
        optionsList.add(new Options(9,Constants.QUIT));
        new Options().createMenu(optionsList);
    }

}
