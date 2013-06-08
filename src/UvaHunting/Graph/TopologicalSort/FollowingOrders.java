package programming;

import java.io.*;
import java.util.*;

public class FollowingOrders {

    static void swap(char[] c, int i, int j) {
        char t = c[ i];
        c[i] = c[ j];
        c[ j] = t;
    }
    
   

    static boolean nextPermutation(char[] c) {
        int n = c.length;
        int k = -1;
        for (int i = n - 2; i >= 0; --i) {
            if (c[ i] < c[ i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return false;
        }
        int l = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (c[ k] < c[ i]) {
                l = i;
                break;
            }
        }
        swap(c, k, l);
        for (int i = k + 1; i < (n + k + 1) / 2; ++i) {
            swap(c, i, n + k - i);
        }
        return true;
    }
    static String r;

    public static void formatR(char c[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (Character.isLetter(c[i])) {
                sb.append(c[i]);
            }
        }
        r = sb.toString();
    }

    public static boolean checkAll(char[] c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        for (int i = 0; i < r.length() - 1; i = i + 2) {
            int m = sb.toString().indexOf(r.charAt(i));
            int n = sb.toString().indexOf(r.charAt(i + 1));
            if (m > n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (br.ready()) {
            char c[] = br.readLine().toCharArray();
            Arrays.sort(c);
            StringBuilder sr = new StringBuilder();
            c = sr.append(c).toString().trim().toCharArray();
            formatR(br.readLine().toCharArray());
            do {
                if (checkAll(c)) {
                    StringBuilder s = new StringBuilder();
                    s.append(c);
                    System.out.println(s.toString());
                }
            } while (nextPermutation(c));

            if (br.ready()) {
                System.out.println();
            }
        }

    }
}
