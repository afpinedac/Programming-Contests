package programming;

import java.io.*;
import java.util.*;

public class AllWalksofLengthN {

    public static int N;
    public static int W;
    public static int s[];
    public static TreeSet<int[]> t;
    public static int M[][];
    public static Comparator<int[]> c;
    public static boolean visited[];

    public static void print(int s[]) {
        System.out.println(Arrays.toString(s));
    }

    public static void backtrack(int k, int s[], int level) {
        //  print(s);
        if (level == W) {
            int s1[] = s.clone();
            // print(s1);
            t.add(s1);

        } else {
            for (int i = 0; i < N; i++) {
                if (M[k][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    s[level] = i + 1;
                    backtrack(i, s, level + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while (br.ready()) {
            String l[] = br.readLine().split("[ ]+");
            N = Integer.parseInt(l[0]);
            W = Integer.parseInt(l[1]) + 1;
            M = new int[N][N];
            for (int i = 0; i < N; i++) {
                l = br.readLine().split("[ ]+");
                for (int j = 0; j < l.length; j++) {
                    M[i][j] = Integer.parseInt(l[j]);
                }
            }
            br.readLine();


            t = new TreeSet<int[]>(new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    for (int i = 0; i < o1.length; i++) {
                        if (o1[i] < o2[i]) {
                            return -1;
                        } else if (o1[i] > o2[i]) {
                            return 1;
                        }
                    }
                    return 0;
                }
            });


            s = new int[W];
            visited = new boolean[N];
            visited[0] = true;
            //   System.out.println("pasa");
            s[0] = 1;
            backtrack(0, s, 1);


            if (t.size() > 0) {
                for (int ss[] : t) {
                    String sol = "";
                    for (int i = 0; i < W; i++) {
                        sol += "," + ss[i];
                    }
                    System.out.println("(" + sol.substring(1) + ")");
                }
            } else {
                System.out.println("no walk of length "+(W-1));
            }
            if (br.ready()) {
                System.out.println();
            }



        }
    }
}
