//package programming;

import java.io.*;
import java.util.*;

public class TheProblemoftheCrazyLinguistic {

    public static float p[] = {12.53f, 1.42f, 4.68f, 5.86f, 13.68f, 0.69f, 1.01f, 0.70f, 6.25f, 0.44f, 0.00f, 4.97f, 3.15f, 6.71f, 8.68f, 2.51f, 0.88f, 6.87f, 7.98f, 4.63f, 3.93f, 0.90f, 0.02f, 0.22f, 0.90f, 0.52f};
    public static int N, vl, ll;    ;
    public static String letter = "bcdfghjklmnpqrstvwxyz";
    public static String vowel = "aeiou";
    public static int vu[],lu[];    
    public static float suma,find;

    public static float sbc(char s[]) {
        float sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum += ((i + 1) * p[s[i] - 'a']);
        }
        return sum;
    }

    public static void backtrack(int k, char[] sol) {
        if (k == N) {
            find++;
            suma += sbc(sol);
        } else {
            if (k % 2 != 0) {
                for (int i = 0; i < vl; i++) {
                    if (vu[i] < 2) {
                        vu[i]++;
                        sol[k] = vowel.charAt(i);
                        backtrack(k + 1, sol);
                        vu[i]--;
                    }
                }
            } else {
                for (int i = 0; i < ll; i++) {
                    if (lu[i] < 2) {
                        lu[i]++;
                        sol[k] = letter.charAt(i);
                        backtrack(k + 1, sol);
                        lu[i]--;
                    }

                }
            }
        }

    }
    
    public static void main(String args[]) throws Exception {
       // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        vl = vowel.length();
        ll = letter.length();
        while (T-- > 0) {
            String w = br.readLine();
            N = w.length();          
            char sol[] = new char[N];
            sol[0] = w.charAt(0);
            vu = new int[vowel.length()];
            lu = new int[letter.length()];
            lu[letter.indexOf(w.charAt(0))]++;
            suma = find = 0;
            backtrack(1, sol);
            suma /= find;
            System.out.println(sbc(w.toCharArray()) < suma ? "below" : "above or equal");
        }

    }
}
