package com.company;

import java.util.Scanner;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ссылку: ");
        String scanURL = in.nextLine();
        in.close();

        String docFromURL = Pars.getDocFromURL(scanURL);
        OutMap.ediStr(docFromURL);
    }
}