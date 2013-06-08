package programming;

import java.util.*;
import java.io.*;

public class Whats_Cryptanalysis {

   static  class datos implements Comparable<datos> {

        char letra;
        int value;

        datos(char a, int b) {
            letra = a;
            value = b;
        }

        @Override
        public int compareTo(datos o) {
            if (this.value > o.value) {
                return -1;
            } else if (this.value < o.value) {
                return 1;
            } else {
                if (this.letra < o.letra) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    public static void main(String s[]) throws Exception {
    //    BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = Character.toUpperCase(line.charAt(j));
                if (Character.isLetter(c)) {
                    if (tm.containsKey(c)) {
                        tm.put(c, tm.get(c) + 1);
                    } else {
                        tm.put(c, 1);
                    }
                }
            }

        }


        TreeSet<datos> ts=new TreeSet<datos>();
        
        for (Map.Entry<Character, Integer> x : tm.entrySet()) {
            ts.add(new datos(x.getKey(),x.getValue()));
        }
        
       for(datos d:ts){
           System.out.println(d.letra + " " + d.value);
       }
        

    }
}
