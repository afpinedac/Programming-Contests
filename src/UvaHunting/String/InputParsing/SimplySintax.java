package UvaHunting.String.InputParsing;

import java.io.*;
import java.util.*;
import java.math.*;

public class SimplySintax {

    static char[] word;

    static boolean check(int i, int j) {     
        if (i > j) {
            return true;
        } else if (i == j) {
            return word[i] < 'p' ? false : true;
        } else {         
            char a = word[i];
            char b = word[j];
            if (a >= 'p') {                
                return false;
            }
            if (b < 'p') {
                return false;
            }
            if (a == 'N') {
                return check(i + 1, j);
            } else {
                if (i + 1 == j) {                 
                    return false;
                } else {                   
                    return check(i + 1, j - 1);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        String s;
        while ((s = br.readLine()) != null) {
            word = s.toCharArray();           
            System.out.println(check(0, word.length - 1) ? "YES" : "NO");
        }

    }
}
