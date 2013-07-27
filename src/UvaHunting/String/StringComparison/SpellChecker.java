package UvaHunting.String.StringComparison;

import java.io.*;
import java.util.*;
import java.math.*;

public class SpellChecker {

    static HashSet<String> dictionary;
    static TreeMap<Integer, String> t1;
    static TreeMap<String, Integer> t2;
    static TreeSet<n_word> response;
    static boolean found;

    static class n_word implements Comparable<n_word> {

        int id;
        String word;

        n_word(int id, String word) {
            this.id = id;
            this.word = word;
        }

        @Override
        public int compareTo(n_word o) {
            return this.id - o.id;
        }
    }

    static boolean in_dictionary(String word) {
        if (dictionary.contains(word)) {
            response.add(new n_word(t2.get(word), word));
            found = true;
            return true;
        }
        return false;

    }

    static boolean check_word(String s) {


        //check changing one letter    
        for (char c = 'a'; c <= 'z'; c++) {
            StringBuilder word = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char old = s.charAt(i);
                word.setCharAt(i, c);
                in_dictionary(word.toString());
                word.setCharAt(i, old);
            }
        }

        //check deleting one letter
        for (int i = 0; i < s.length(); i++) {
            in_dictionary(s.substring(0, i) + s.substring(i + 1, s.length()));
        }

        //check adding one letter
        for (char c = 'a'; c <= 'z'; c++) {
            StringBuilder word = new StringBuilder(s);
            for (int i = 0; i < s.length() + 1; i++) {
                word.insert(i, c);
                in_dictionary(word.toString());
                word.deleteCharAt(i);
            }
        }

        return false;


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));

        int n = Integer.parseInt(br.readLine());
        br.readLine();


        while (n-- > 0) {

            dictionary = new HashSet<String>();
            t2 = new TreeMap<String, Integer>();
            int k = 0;

            while (true) {
                String s = br.readLine().trim();
                if (s.equals("#")) {
                    break;
                }
                dictionary.add(s);
                t2.put(s, ++k);
            }


            while (true) {
                String s = br.readLine().trim();
                if (s.equals("#")) {
                    break;
                }
                response = new TreeSet<n_word>();
                if (in_dictionary(s)) {
                    System.out.println(s + " is correct");
                } else {
                    found = false;
                    check_word(s);
                    if (found) {
                        String r = "";
                        for (n_word t : response) {
                            r += " " + t.word;
                        }
                        System.out.println(s + ": " + r.toString().trim());
                    } else {
                        System.out.println(s + ":");
                    }
                }

            }
            if (n > 0) {
                System.out.println();
            }
        }
    }
}
