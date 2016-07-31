package com.twu.biblioteca;


public class FormatPrint {
    public String formatString(String str) {
        return String.format("%-30s", str);
    }

    public String formatShortString(String str) {
        return String.format("%-10s", str);
    }

    public void drawLine() {
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
