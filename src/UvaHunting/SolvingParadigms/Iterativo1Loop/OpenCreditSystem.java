package UvaHunting.SolvingParadigms.Iterativo1Loop;

import java.io.*;
import java.util.*;
import java.math.*;

public class OpenCreditSystem {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {

            String s;
            while (true) {
                s = br.readLine();
                if (!s.equals("")) {
                    break;
                }
            }
            int t = Integer.parseInt(s);
            int[] a = new int[t];
            int c = -1;

            int max = Integer.MIN_VALUE;

            int[] difs = new int[t];
            while (c + 1 < t) {
                String r = br.readLine();
                if (!r.equals("")) {
                    a[++c] = Integer.parseInt(r);
                    if (a[c] > max) {
                        difs[c] = max - a[c];
                        max = a[c];
                    } else {
                        difs[c] = max - a[c];
                    }

                }
            }
            max = difs[1];
            for (int i = 2; i < t; i++) {
                max = Math.max(max, difs[i]);
            }
            sb.append(max).append("\n");


        }
        System.out.println(sb.toString().trim());

    }
}
