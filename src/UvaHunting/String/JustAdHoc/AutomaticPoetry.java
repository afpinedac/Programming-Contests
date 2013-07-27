package UvaHunting.String.JustAdHoc;

import java.io.*;
import java.util.*;
import java.math.*;

public class AutomaticPoetry {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));

        int n = Integer.parseInt(br.readLine());


        while (n-- > 0) {
            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();


            int p[] = new int[4];


            p[0] = s1.indexOf('<');
            p[1] = s1.indexOf('>');
            p[2] = s1.lastIndexOf('<');
            p[3] = s1.lastIndexOf('>');

            String replace = s1.substring(p[2] + 1, p[3]) + "" + s1.substring(p[1] + 1, p[2]) + "" + s1.substring(p[0] + 1, p[1]) + "" + s1.substring(p[3] + 1);
            //System.out.println("-->" + replace);


            StringBuilder sb = new StringBuilder(s1);
            for (int i = 0; i < 4; i++) {
                sb.deleteCharAt(p[i] - i);
            }

            s2 = s2.replace("...", replace);

            System.out.println(sb.toString());
            System.out.println(s2);






        }


    }
}
