package UvaHunting.SolvingParadigms.Greedy;

//package programming;

import java.io.*;
import java.util.*;

public class MaxSumII {

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String args[]) throws Exception {
       // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            boolean ceros = true;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(br.readLine());
                if (x != 0) {
                    ceros = false;
                    sb.append(" ").append(x);
                }
            }
            System.out.println(ceros ? "0" : sb.toString().substring(1));

        }

    }
}
