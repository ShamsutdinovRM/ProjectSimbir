package com.company;

import java.util.HashMap;
import java.util.Map;

public class OutMap {

    public static void ediStr(String buf) {
        String per = " «»,.!?\";:[]()\n\r\t'";
        char perChar[] = per.toCharArray();
        int num = per.length();
        for (int i = 0; i < num; i++) {
            String kek = perChar[i] + "";
            buf = buf.replace(kek, ";");
        }
        String[] bufString = buf.split(";");
        createMap(bufString);
    }

    public static void createMap(String[] edStr) {
        Map<String, Integer> karta = new HashMap<>();
        for (int i = 0; i < edStr.length; i++) {
            if (!karta.containsKey(edStr[i]) && edStr[i].length() > 0)
                karta.put(edStr[i], 1);
            else if (edStr[i].length() > 0)
                karta.put(edStr[i], karta.get(edStr[i]) + 1);
        }
        for (Map.Entry<String, Integer> items : karta.entrySet())
            System.out.println(items.getKey() + " - " + items.getValue());
    }
}
