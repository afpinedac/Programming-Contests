package UvaHunting.String.StringMatching;

import java.io.*;
import java.util.*;
import java.math.*;

public class X_ExtendToPalindrom_KMP {

    static boolean is_palindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (s.equals(sb.reverse().toString())) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        String s;
        while ((s = br.readLine()) != null) {
            if (is_palindrome(s)) {
                System.out.println(s);
            } else {
                char c = s.charAt(s.length() - 1);
                int idx = s.substring(0, s.length() - 1).indexOf(c);
                if (idx == -1) {
                    System.out.println(s + s.substring(1));
                } else {
                    boolean found = false;
                    while (idx != -1) {
                        if (is_palindrome(s.substring(idx))) {
                            found = true;
                            break;
                        }
                        idx = s.indexOf(c, idx + 1);
                    }
                    if (found) {
                        StringBuilder sb = new StringBuilder(s.substring(0, idx));
                        System.out.println(s.substring(0) + sb.reverse().toString());
                    } else {
                        System.out.println(s + s.substring(1));
                    }
                }
            }
        }

    }
}
