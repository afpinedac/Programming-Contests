package UvaHunting.String.EncodeDecode;

import java.io.*;
import java.util.*;
import java.math.*;

public class Uncompress {

    static ArrayList<String> words = new ArrayList<String>();

    static boolean is_number(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    static String check_line(String s) {
        String w[] = s.trim().split("[^a-zA-Z0-9]+");  // take care with the expression \\w because it takes alphanumerics values but also the underscore character (_)
        for (String t : w) {
            //  System.out.println(t);
            t = t.trim();
            if (!t.equals("")) {
                if (is_number(t)) {
                    //  System.out.println(t);
                    int value = Integer.parseInt(t);
                    String word = words.remove(value - 1);

                    s = s.replaceFirst(t, word);
                    words.add(0, word);
                } else {
                    words.add(0, t);
                }
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            System.out.println(check_line(s));
        }
        System.exit(0);

    }
}
