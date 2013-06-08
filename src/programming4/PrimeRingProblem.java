package programming;

import java.io.*;
import java.util.*;

public class PrimeRingProblem {

    static boolean p[];
    static int N;
    static BitSet used;
    static StringBuilder res;

    public static void backtrack(int[] c, int k) {
        if (k == N) {
            if (p[1 + c[N - 1]]) {
                res.append("\n").append(1);
                for (int i = 1; i < N; i++) {
                    res.append(" ").append(c[i]);
                }
            }
        } else {
            for (int i = 2; i <= N; i++) {
                if (p[c[k - 1] + i]) {
                    if (!used.get(i)) {
                        used.set(i);
                        c[k] = i;
                        backtrack(c, k + 1);
                        used.set(i, false);
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        p = new boolean[33];
        p[1] = p[2] = p[3] = p[5] = p[7] = p[11] = p[13] = p[17] = p[19] = p[23] = p[29] = p[31] = true;

        int t = 0;
        res = new StringBuilder();
        while (br.ready()) {
            N = Integer.parseInt(br.readLine().trim());
            int c[] = new int[N + 1];
            c[0] = 1;
            used = new BitSet();
            res.append("Case ").append(++t).append(":");
            backtrack(c, 1);
            if (br.ready()) {
                res.append("\n").append("\n");
            }
        }
        System.out.println(res.toString());
    }
}
