package UvaHunting.Introduction.Easy;

import java.io.*;
import java.util.*;
import java.math.*;

public class TheSwallowingGround {

    public static void main(String args[]) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (br.ready()) {

            int n = Integer.parseInt(br.readLine().trim());

            while (n-- > 0) {
                br.readLine();
                int w = Integer.parseInt(br.readLine().trim());
                //   System.out.println(w);

                TreeSet<Integer> ts = new TreeSet<Integer>();
                for (int i = 0; i < w; i++) {
                    String s[] = br.readLine().trim().split("[ ]+");
                    ts.add(Math.abs(Integer.parseInt(s[0]) - Integer.parseInt(s[1])));
                }

                System.out.println(ts.size() == 1 ? "yes" : "no");

                if (n > 0) {
                    System.out.println("");
                }


            }


        }


    }
}
