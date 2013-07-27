package UvaHunting.String.StringComparison;

import java.io.*;
import java.util.*;
import java.math.*;

public class AutomaticCorrectionOfMisspellings {

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
                if (in_dictionary(word.toString())) {
                }
                word.setCharAt(i, old);
            }
        }

        //check deleting one letter
        for (int i = 0; i < s.length(); i++) {
            if (in_dictionary(s.substring(0, i) + s.substring(i + 1, s.length()))) {
            }
        }

        //check adding one letter
        for (char c = 'a'; c <= 'z'; c++) {
            StringBuilder word = new StringBuilder(s);
            for (int i = 0; i < s.length() + 1; i++) {
                word.insert(i, c);
                if (in_dictionary(word.toString())) {
                }
                word.deleteCharAt(i);
            }
        }

        //check interchanging adjacent letters
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length() - 1; i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(i + 1));
            sb.setCharAt(i + 1, c);
            if (in_dictionary(sb.toString())) {
            }
            //rollback the action
            c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(i + 1));
            sb.setCharAt(i + 1, c);

        }

        return false;


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));

        int n = Integer.parseInt(br.readLine());
        //  br.readLine();
        dictionary = new HashSet<String>();
        t2 = new TreeMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();

            dictionary.add(s);
            t2.put(s, i + 1);
        }

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
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
                        break;
                    }
                    System.out.println(s + " is a misspelling of " + r.toString().trim());
                } else {
                    System.out.println(s + " is unknown");
                }
            }



        }
    }
}
