package UvaHunting.String.FrecuencyCounting;

//package programming;

import java.io.*;
import java.util.*;

public class PrimeFrecuency {

    public static void print(Object o) {
        System.out.println(o);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i = i + 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws Exception {
       // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int tt = 1;
        int t = Integer.parseInt(br.readLine());
      //  print(t);
        while (t-- > 0) {
            String l = br.readLine();
            int n = l.length();
            int f[] = new int[255];

            for (int i = 0; i < n; i++) {
                f[l.charAt(i)]++;
            }

            boolean found = false;
            String sol = "";
            for (int i = 0; i < 255; i++) {
                if (isPrime(f[i])) {
                    found = true;
                    char ch = (char) (i);
                    sol += ch;
                }
            }

            print(found ? "Case " + (tt++) + ": " + sol : "Case " + (tt++) + ": empty");
        }


    }
}
