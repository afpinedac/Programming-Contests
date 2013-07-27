package UvaHunting.String.JustAdHoc;

import java.io.*;
import java.util.*;
import java.math.*;

public class X_Main_next_permutatio {

    static boolean used[];
    static String permutation;
    static char word[];
    static int N;
    static boolean found;
    static TreeSet<String> ts;

    static void permute(int k, char c[]) {
        if (found) {
            return;
        }
        if (k == N) {
            //   System.out.println(">>" + String.valueOf(c));
            ts.add(String.valueOf(c));
            if (String.valueOf(c).equals(permutation)) {
                found = true;
            }


        } else {
            for (int i = 0; i < N; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                c[k] = word[i];
                permute(k + 1, c);

                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));



        while (true) {
            permutation = br.readLine().trim();
            // System.out.println("x = " +  permutation);
            if (permutation.equals("#")) {
                break;
            }
            N = permutation.length();
            word = permutation.toCharArray();
            ts = new TreeSet<String>();


            Arrays.sort(word);
            // System.out.println(Arrays.toString(word));
            used = new boolean[N];
            found = false;
            permute(0, new char[N]);
            System.out.println(String.format("%10s", ts.size()));
        }
    }
}
