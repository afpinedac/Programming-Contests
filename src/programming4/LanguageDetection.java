//package programming;

import java.io.*;
import java.util.*;

public class LanguageDetection {

    public static void main(String args[]) throws Exception {
       // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("HELLO", "ENGLISH");
        hm.put("HOLA", "SPANISH");
        hm.put("HALLO", "GERMAN");
        hm.put("BONJOUR", "FRENCH");
        hm.put("CIAO", "ITALIAN");
        hm.put("ZDRAVSTVUJTE", "RUSSIAN");

        String L;
        int t=1;
        while (true) {
            L = br.readLine();
            if(L.equals("#"))break;
           System.out.println(hm.containsKey(L)? "Case "+(t++)+": "+ hm.get(L) :"Case "+(t++)+": UNKNOWN");
        }

    }
}
