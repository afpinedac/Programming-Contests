package programming;

import java.io.*;
import java.util.*;

public class FlightPlanner {

    static int n;
    static String M[][];
    static int dx[] = {-1, 0, 1};
    static int memo[][];
    static int cost[] = {60, 30, 20};
    static int sol[][];

    static boolean valid(int i,int j) {
        return i >= 0 && i < 10 && i>=j; 
    }

    public static int fly(int x, int y) {
        // System.out.println("-->" + x + "  " + y);
        if (y == n - 1) {
            if (x == 9) {
                int value = 30 - (Integer.parseInt(M[x][y]));
                return memo[x][y] = value;
            } else {
                return 1000000;
            }
        } else {
            if (memo[x][y] != -1) {
                //System.out.println("Este valor ya se calculo es: " + memo[x][y]);
                return memo[x][y];
            } else {
                int ans, ans1, ans2, ans3, pos;
                ans = ans1 = ans2 = ans3 = pos = 9999;
                if (valid(x - 1,y+1)) {
                    ans1 = fly(x - 1, y + 1) + (60 - (Integer.parseInt(M[x][y])));
                }
                if (valid(x,y+1)) {
                    ans2 = fly(x, y + 1) + (30 - (Integer.parseInt(M[x][y])));
                }
                if (valid(x + 1,y+1)) {
                    ans3 = fly(x + 1, y + 1) + (20 - (Integer.parseInt(M[x][y])));
                }

                if (ans1 <= ans2 && ans1 <= ans3) {
                    pos = 1;
                    ans = ans1;
                } else if (ans2 <= ans1 && ans2 <= ans3) {
                    pos = 2;
                    ans = ans2;
                } else {
                    pos = 3;
                    ans = ans3;
                }
                sol[x][y] = pos;
                //System.out.println("x: " + x + " y: " + y + " value: " + ans);
                return memo[x][y] = ans;
            }
        }

    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());
        br.readLine();

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine()) / 100;
            System.out.println("-->" + n);
            M = new String[10][n];
            // System.out.println(n);
            for (int i = 0; i < 10; i++) {
                String xx = br.readLine();
                // System.out.println("->" + xx);
                M[i] = xx.split("[ ]+");
            }

            sol = new int[10][n];

            memo = new int[10][n];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < n; j++) {
                    memo[i][j] = -1;
                }
            }
            System.out.println(fly(9, 0));
            
             for (int i = 0; i < 10; i++) {
                System.out.println(Arrays.toString(memo[i]));
            }

            for (int i = 0; i < 10; i++) {
                System.out.println(Arrays.toString(sol[i]));
            }


            if (br.ready()) {
                br.readLine();
                System.out.println();
            }
        }
    }
}
