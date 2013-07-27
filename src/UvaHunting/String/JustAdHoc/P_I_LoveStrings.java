package UvaHunting.String.JustAdHoc;

import java.io.*;
import java.util.*;
import java.math.*;

public class P_I_LoveStrings {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String s = br.readLine().trim();
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                String q = br.readLine().trim();
                System.out.println(s.contains(q) ? "y" : "n");
            }

        }

    }
}
