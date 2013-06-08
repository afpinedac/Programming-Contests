package programming;

import java.io.*;
import java.util.*;

public class CD {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line[] = br.readLine().split("[ ]+");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            if (N == 0 && M == 0) {
                break;
            }
            BitSet bs1 = new BitSet();            
            for (int i = 0; i < N; i++) {
                bs1.set(Integer.parseInt(br.readLine()));
            }
            int c = 0;
            for (int i = 0; i < M; i++) {               
                if (bs1.get(Integer.parseInt(br.readLine()))) {
                    c++;
                }
            }
            System.out.println(c);
        }
    }
}
