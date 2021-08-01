package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Pars {
    public static String getDocFromURL(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            String bodyHTML = doc.body().toString().toUpperCase();
            return getTextFromDoc(bodyHTML);
        } catch (Exception ex) {
            System.out.println("Введена не ссылка, попробуйте снова!");
            return "";
        }

    }

    public static String getTextFromDoc(String doc) {
        char docChar[] = doc.toCharArray();
        String outBuf = "";
        boolean shouldOutput = true;
        int num = doc.indexOf("<SCRIPT") == -1 ? (doc.length()) : (doc.indexOf("<SCRIPT"));
        for (int i = 0; i < num; i++) {
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
