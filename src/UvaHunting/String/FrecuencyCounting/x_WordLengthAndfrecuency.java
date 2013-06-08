package UvaHunting.String.FrecuencyCounting;

//package programming;

import java.io.*;
import java.util.*;

public class x_WordLengthAndfrecuency {
    
    public static void print(Object o) {
        System.out.println(o);
    }
    
    public static void main(String args[]) throws Exception {
     //   BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (br.ready()) {
            StringBuilder sb = new StringBuilder();
            int f[] = new int[100];
            while (true) {
                String l = br.readLine().trim();
                if (l.equals("#")) {
                    break;
                }
                if (sb.toString().endsWith("-")) {
                    sb.append(l);
                } else {
                    sb.append(" ").append(l);
                }
            }
            
            String res[] = sb.toString().split("[.|,|?| |!|¡]+");
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
            
            for (int i = 1; i < 35; i++) {
                if (f[i] > 0) {
                    print(i + " " + f[i]);
                }
            }
            
            if (br.ready()) {
                print("");
            }
            
        }
        
    }
}
