//package programming;

import java.io.*;
import java.util.*;

public class Backtothe8QueenProblem {

    public static BitSet fil;
    public static BitSet col;
    public static BitSet d1;
    public static BitSet d2;
    public static char[][] sol;
    public static ArrayList<char[][]> sols;

    public static int get_fil(char M[][], int col) {
        for (int i = 0; i < 8; i++) {
            if (M[i][col] == '*') {
                return i + 1;
            }
        }
        return -1;
    }

    public static void backtrack(int k, char[][] sol) {
        if (k == 8) {
            char res[][] = new char[8][8];
            for (int i = 0; i < 8; i++) {
                res[i] = sol[i].clone();
            }
            //printM(res);
            sols.add(res);
        } else {
            for (int i = 0; i < 8; i++) {
                if (!col.get(i) && !d1.get(7 - i + k) && !d2.get(i + k)) {
                    col.set(i);
                    d1.set(7 - i + k);
                    d2.set(i + k);
                    sol[k][i] = '*';
                    backtrack(k + 1, sol);
                    sol[k][i] = ' ';
                    col.set(i, false);
                    d1.set(7 - i + k, false);
                    d2.set(i + k, false);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sols = new ArrayList<char[][]>();
        fil = new BitSet();
        col = new BitSet();
        d1 = new BitSet();
        d2 = new BitSet();

        backtrack(0, new char[8][8]);


        int t = 1;
        while (br.ready()) {
            String pos[] = br.readLine().split("[ ]+");
            int min = Integer.MAX_VALUE;
            for (char[][] M : sols) {
                int suma = 0;
                for (int i = 0; i < 8; i++) {
                    suma += (get_fil(M, i) == Integer.parseInt(pos[i])) ? 0 : 1;
                }
                min = Math.min(min, suma);
            }
            System.out.println("Case " + (t++) + ": " + min);
        }
    }
}
