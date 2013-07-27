package UvaHunting.String.StringMatching;

import java.io.*;
import java.util.*;
import java.math.*;

public class P_abormal89 {

    static boolean is_palindrome(String s) {
        StringBuilder s1 = new StringBuilder(s);
        return s1.reverse().toString().equals(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       //  BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {


            String s = br.readLine().trim();
            if (s.length() == 1) {
                System.out.println("simple");
                continue;
            }

            boolean found = false;
            for (int j = 1; j < s.length(); j++) {
                if (is_palindrome(s.substring(0, j)) && is_palindrome(s.substring(j, s.length()))) {
                    System.out.println("alindrome");
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (is_palindrome(s)) {
                    System.out.println("palindrome");
                } else {
                    System.out.println("simple");
                }
            }

        }


    }
}
