package UvaHunting.SolvingParadigms.Iterativo2Loop;

import java.io.*;
import java.util.*;
import java.math.*;

public class VitosFamily {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String s[] = br.readLine().split("[ ]+");
            int r = Integer.parseInt(s[0]);

            int[] rel = new int[r];
            for (int i = 0; i < r; i++) {
                //ts.add(Integer.parseInt(s[i + 1]));
                rel[i] = Integer.parseInt(s[i + 1]);
            }


            Arrays.sort(rel);

            int median = rel[r / 2];


            int suma1 = 0;
            //int suma2 = 0;
            for (int i = 0; i < r; i++) {
                suma1 += Math.abs(rel[i] - median);
            }
            System.out.println(suma1);







        }

    }
}
