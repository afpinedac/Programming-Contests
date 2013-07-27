package UvaHunting.SolvingParadigms.Iterativo2Loop;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        int t = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 0) {
                break;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }


            int q = Integer.parseInt(br.readLine().trim());
            sb.append("Case ").append(++t).append(":").append("\n");

            for (int i = 0; i < q; i++) {

                int c = Integer.parseInt(br.readLine().trim());

                int min = Integer.MAX_VALUE;
                int value = min;

                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int dif = Math.abs((a[j] + a[k]) - c);
                        if (dif < min) {
                            min = dif;
                            value = a[j] + a[k];
                        }
                    }
                }
                sb.append("Closest sum to " + c + " is " + (value) + ".").append("\n");
            }
        }

        System.out.println(sb.toString().trim());

    }
}
