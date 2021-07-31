package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.lang.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите ссылку: ");
        String scannURL = in.nextLine();
        in.close();

        String docFromURL = getDocFromURL(scannURL);

        String textFromDoc = getTextFromDoc(docFromURL);
        //System.out.println(textFromDoc);

        createMap(textFromDoc);


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

    public static Map createMap(String buf){

        String per = " «»,.!?\";:[]()\n\r\t\'";
        char perChar[] = per.toCharArray();
        int num = per.length();
        Map<String, Integer> karta = new HashMap<String, Integer>();
        for (int i = 0; i < num; i++){
            String kek = perChar[i] + "";
            buf = buf.replace(kek, ";");
        }
        //String[] bufString = buf.split(";");
        char[] kek = buf.toCharArray();
        for (int i = 0; i < buf.length(); i++)
        {
            if (kek[i] != ';')
                System.out.println(kek[i]);
        }


        return karta;
    }

}