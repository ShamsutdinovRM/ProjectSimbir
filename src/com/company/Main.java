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
        String[] edStr = ediStr(textFromDoc);
        Map newMap = createMap(edStr);


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

    public static String[] ediStr(String buf){

        String per = " «»,.!?\";:[]()\n\r\t\'";
        char perChar[] = per.toCharArray();
        int num = per.length();
        for (int i = 0; i < num; i++){
            String kek = perChar[i] + "";
            buf = buf.replace(kek, ";");
        }
        //System.out.println(buf);
        String[] bufString = buf.split(";");

        return bufString;
    }

    public static Map createMap(String[] edStr)
    {
        Map<String, Integer> karta = new HashMap<String, Integer>();
        int count = 0;
        for (int i = 0; i < edStr.length; i++) {
            if (karta.containsKey(edStr) == false)
            {

            }
        }
        return karta;
    }

}