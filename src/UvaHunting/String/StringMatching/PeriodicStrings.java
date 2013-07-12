package UvaHunting.String.StringMatching;

import java.io.*;
import java.util.*;
import java.math.*;

public class PeriodicStrings {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));



        int n = Integer.parseInt(br.readLine());
        br.readLine();
        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
            if (i + 1 != n) {
                br.readLine();
            }
            boolean found = false;

            for (int j = 1; j <= s.length() / 2; j++) {
                String ss[] = s.split("(" + s.substring(0, j) + ")");
                if (ss.length == 0) {
                    System.out.println(j);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(s.length());
            }
            if (i + 1 != n) {
                System.out.println();
            }
        }

    }
}
