package HackerRank.MiscellaneousCodeGolf;

import java.io.*;
import java.util.*;

public class X_Sudoku {

    static boolean[][] f, c;
    static int M[][];
    static boolean t;

    public static void ps(int[][] m) {
        System.out.println("----");
        for (int i = 0; i < 9; i++) {
            String l = "";
            for (int j = 0; j < 9; j++) {
                l += m[i][j] + " ";
            }
            System.out.println(l.trim());
        }
    }

    public static void sudoku(int[][] S, int i, int j) {
        if (t) {
            return;
        }
        if (i == 8 && j == 9) {
            t = true;
            ps(S);
        } else if (j == 9) {
            sudoku(S, i + 1, 0);
        } else if (i == 9) {
            return;
        }
        for (int k = 0; k < 9; k++) {
            if (!f[i][k] && !c[j][k]) {
                f[i][k] = c[j][k] = true;
                S[i][j] = k + 1;
                sudoku(S, i, j + 1);

                f[i][k] = c[j][k] = false;
            }

        }



    }

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        int n = Integer.parseInt(br.readLine());
        //System.out.println(n);
        for (int i = 0; i < n; i++) {
            M = new int[9][9];
            f = new boolean[9][9];
            c = new boolean[9][9];
            t = false;
            for (int j = 0; j < 9; j++) {
                String l[] = br.readLine().split("[ ]+");
                for (int k = 0; k < 9; k++) {
                    int m = Integer.parseInt(l[k]);
                    if (m != 0) {
                        f[j][m - 1] = c[k][m - 1] = true;
                    }
                    M[j][k] = Integer.parseInt(l[k]);
                }
            }
        }
        // ps(M);
        sudoku(new int[9][9], 0, 0);
    }
}
