package programming;

import java.io.*;
import java.util.*;

public class TheSettlersOfCatan {
    static int N;
    static int A;
    static BitSet visited;
    static boolean M[][];
    static boolean E[][];
    static int max;  
    public static void backtrack(int node, int level) { 
 
       max=Math.max(level, max);
        for (int i = 0; i < N; i++) {        
            if (M[node][i] && !E[node][i]) {
                E[node][i] =E[i][node]= true;                
                backtrack(i, level + 1);
                E[node][i]=E[i][node] = false;
            }
        }
    }

    public static void main(String args[]) throws Exception {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String l[] = br.readLine().split("[ ]+");
             N = Integer.parseInt(l[0]);
             A = Integer.parseInt(l[1]);
            if (N == 0 && A == 0) {
                break;
            }
            M = new boolean[N][N];
            for (int i = 0; i < A; i++) {
                l = br.readLine().split("[ ]+");
                int x=Integer.parseInt(l[0]);
                int y=Integer.parseInt(l[1]);
                M[x][y] = true;
                M[y][x]= true;
            }
            max = 0;
            for (int i = 0; i < N; i++) {
                E = new boolean[N][N];
                backtrack(i, 0);               
            }            
            System.out.println(max);
        }
    }
}
