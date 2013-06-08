//package programming;

import java.io.*;
import java.util.*;

public class TriangleWave {
    
    public static void print(Object o) {
        System.out.println(o);
    }
    static int a;
    static int f;
    static boolean last;

    public static String generateWave() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= a; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(i);
            }
            sb.append("\n");
        }

        for (int i = a - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                sb.append(i);
            }

            sb.append("\n");
        }


        return last ? sb.toString().trim() : sb.toString();
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());
        last = false;
        while (t-- > 0) {
            if (t == 0) {
                last = true;
            }
            br.readLine();
            a = Integer.parseInt(br.readLine());
            f = Integer.parseInt(br.readLine());
            String wave = generateWave();
            for (int i = 0; i < f; i++) {
                print(wave);
                if (last && i < f - 1) {
                    print("");
                }
            }

        }

    }
}
