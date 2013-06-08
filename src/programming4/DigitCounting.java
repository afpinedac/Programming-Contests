//package programming;

import java.io.*;
import java.util.*;

public class DigitCounting {

   

    public static void main(String args[]) throws Exception {
       // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                sb.append(i);
            }
            int c[] = new int[10];
            int n = sb.length();
            for (int i = 0; i < n; i++) {
                c[sb.charAt(i) - '0']++;
            }
            String s = "";
            for (int a : c) {
                s += " " + a;
            }
            System.out.println(s.trim());
        }


    }
}
