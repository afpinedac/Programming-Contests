package UvaHunting.Introduction.Medium;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));



        int n = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append("Case ").append(i).append(": ");


            String s = br.readLine().trim();
            int[] a = new int[100];
            int p = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '+') {
                    a[p] += 1;
                    a[p] %= 256;
                } else if (c == '-') {
                    a[p] -= 1;
                    a[p] = (a[p] < 0) ? 255 : 0;
                } else if (c == '<') {
                    p--;
                    p = (p < 0) ? 99 : p;
                } else if (c == '>') {
                    p = (++p % 100);
                }
            }


            for (int k : a) {
                // System.out.print(" " + Integer.toHexString(k));
                sb.append(String.format("%2s", Integer.toHexString(k)).replace(' ', '0').toUpperCase()).append(" ");
            }
            // sb.trimToSize();



            sb.append("\n");

        }
        //   System.out.println("");
        System.out.println(sb.toString().trim());
    }
}
