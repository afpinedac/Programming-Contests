package programming4;

import java.io.*;
import java.util.*;

public class TheDominoesSolitare {
 

    public static class point {

        int x;
        int y;

        point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + "-" + y;
        }
    }
    static int N, M;
    static point pieces[];
    static boolean used[];
    static point row[];
    static boolean found;

    public static point getPoint(String line) {
        String s[] = line.split("[ ]+");
        return new point(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
    }

    public static void print() {
        for (int i = 0; i < row.length; i++) {
            System.out.println(row[i]);
        }
    }

    public static boolean isSolution() {
        //print();
        for (int i = 0; i < N + 1; i++) {
            if (row[i].y != row[i + 1].x) {
                return false;
            }
        }
        return true;
    }

    public static point swap(point p) {
        return new point(p.y, p.x);
    }

    public static void backtrack(int col) {
        if (found) {
            return;
        }
        if (col == N + 1) {
            if (isSolution()) {
                found = true;
            }
        } else {
            for (int i = 0; i < M; i++) {
                if (!used[i]) {
                    used[i] = true;
                    row[col] = pieces[i];
                    if (row[col - 1].y == row[col].x) {
                        backtrack(col + 1);
                    }
                    row[col] = swap(pieces[i]);
                    if (row[col - 1].y == row[col].x) {
                        backtrack(col + 1);
                    }
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            M = Integer.parseInt(br.readLine());
            pieces = new point[M];
            used = new boolean[M];
            row = new point[N + 2];
            row[0] = getPoint(br.readLine());
            row[N + 1] = getPoint(br.readLine());
            //  System.out.println("---");
            //  print();            
            // System.out.println("---");

            for (int i = 0; i < M; i++) {
                pieces[i] = getPoint(br.readLine());
            }
            found = false;
            backtrack(1);
            System.out.println((found) ? "YES" : "NO");

        }
    }
}
