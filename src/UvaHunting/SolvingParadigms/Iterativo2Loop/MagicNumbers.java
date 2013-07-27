package UvaHunting.SolvingParadigms.Iterativo2Loop;

import java.io.*;
import java.util.*;
import java.math.*;

public class MagicNumbers {

    static boolean all_diferents(String s) {
        if (s.length() > 10) {
            return false;
        }
        boolean used[] = new boolean[10];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0';
            if (used[idx]) {
                return false;
            } else {
                used[idx] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        int n = Integer.parseInt(br.readLine());
        br.readLine();

        while (n-- > 0) {
           



            if (n > 0) {
                System.out.println("");
                br.readLine();
            }

        }

    }
}
