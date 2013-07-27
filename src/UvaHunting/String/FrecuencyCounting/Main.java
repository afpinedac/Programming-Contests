package UvaHunting.String.FrecuencyCounting;

//package programming;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        boolean first = true;
        while ((s = br.readLine()) != null) {
            if (s.equals("")) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int f[] = new int[100];
            while (true) {

                if (s.charAt(0) == '#') {
                    break;
                }
                if (sb.toString().endsWith("-")) {
                    sb.append(s);
                } else {
                    sb.append(" ").append(s);
                }
                s = br.readLine();
            }

            String res[] = sb.toString().split("[.|,|?| |!|¡]+");
            // System.out.println(Arrays.toString(res));
            for (String x : res) {
                x = x.trim();
                if (x.contains("'") || x.contains("-")) {
                    int c = 0;
                    for (int i = 0; i < x.length(); i++) {
                        char p = x.charAt(i);
                        if (p == '\'' || p == '-') {
                            c++;
                        }
                    }
                    f[x.length() - c]++;
                } else {
                    f[x.length()]++;
                }
            }

            if (!first) {
                System.out.println("");
            }

            for (int i = 1; i < 35; i++) {
                if (f[i] > 0) {
                    System.out.println(i + " " + f[i]);
                }
            }

            if (first) {
                first = false;
            }

        }

    }
}
