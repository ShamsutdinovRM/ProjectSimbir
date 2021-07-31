package com.company;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.lang.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String[] args) throws IOException {


        String per = "«»,.!?\";:[]()\n\r\t\'";
        int num = per.length();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите ссылку: ");
        String scannURL = in.nextLine();
        in.close();

        String docFromURL = getDocFromURL(scannURL);

        String textFromDoc = getTextFromDoc(docFromURL);
        System.out.println(textFromDoc);


    }

    public static String getDocFromURL(String url) throws IOException
    {

        try {
            Document doc = Jsoup.connect(url).get();
            String bodyHTML = doc.body().toString().toUpperCase();
            return bodyHTML;
        }
        catch (Exception ex)
        {
            System.out.println("Введена не ссылка, попробуйте снова!");
            return "";
        }


    }

    public static String getTextFromDoc(String doc)
    {
        char docChar[] = doc.toCharArray();
        String outBuf = "";
        boolean shouldOutput = true;
        int num = doc.indexOf("<SCRIPT") == -1 ? (doc.length()) : (doc.indexOf("<SCRIPT"));
        for (int i = 0; i < num; i++)
        {
            switch (docChar[i]) {
                case '<':
                    shouldOutput = false;
                    continue;
                case '>':
                    shouldOutput = true;
                    continue;
            }
            if (shouldOutput) {
                outBuf += docChar[i];
            }
        }
        return outBuf;
    }

}