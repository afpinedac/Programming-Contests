
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        //  BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        String aa[] = br.readLine().split("[ ]+");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aa[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int b[] = new int[m];
        String bb[] = br.readLine().split("[ ]+");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(bb[i]);
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[j] % a[i] == 0) {
                    max = Math.max(b[j] / a[i], max);
                }
            }
        }

        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[j] % a[i] == 0) {
                    if (b[j] / a[i] == max) {
                        c++;
                    }
                }
            }
        }
        System.out.println(c);



    }
}