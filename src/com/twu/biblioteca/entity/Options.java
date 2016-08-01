package com.twu.biblioteca.entity;

import com.twu.biblioteca.FormatPrint;

import java.util.List;

public class Options {

    private Double menuID;

    private String menuName;

    public Options() {
    }

    public Options(Double menuID, String menuName) {
        this.menuID = menuID;
        this.menuName = menuName;
    }

    public Double getMenuID() {
        return menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void createMenu(List<Options> optionses) {
        FormatPrint formatPrint = new FormatPrint();
        formatPrint.drawLine();
        for (Options option : optionses) {
            System.out.print("| " + option.getMenuName() + "(" + option.getMenuID() + ")" + " |  ");
        }
        System.out.println();
        formatPrint.drawLine();
    }
}
