//package programming;

import java.io.*;
import java.util.*;

public class Emirp {

    public static boolean isPrime(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 2 || n==1) {
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

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String args[]) throws Exception {
         //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (br.ready()) {
            StringBuilder sb = new StringBuilder(br.readLine());
            int a = Integer.parseInt(sb.toString());
            int b = Integer.parseInt(sb.reverse().toString());
            // print(a + " --  " + b);
            if (isPrime(a) && isPrime(b) && a !=b) {
                print(a + " is emirp.");
            } else if (isPrime(a)) {
                print(a + " is prime.");
            } else {
                print(a + " is not prime.");
            }
        }

    }
}
