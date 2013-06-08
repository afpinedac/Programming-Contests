package programming;

import java.io.*;
import java.util.*;

public class X_UnidirectionalTSP {

    static int M, N;
    static int m[][];
    static int memo[][];
    static int path[][];
    static StringBuilder ss;
    static TreeSet<String> ts;

    static int path(int x, int y) {
        if (y == N - 1) {
            return memo[x][y] = m[x][y];
        }

        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        int a1, a2, a3, a;
        a1 = a2 = a3 = a = 99999;

        a1 = path((x - 1 + M) % M, y + 1);
        a2 = path(x, y + 1);
        a3 = path((x + 1) % M, y + 1);

        int pos = -1;
        if (a1 < a2 && a1 < a3) {
            a = a1;
            pos = (x - 1 + M) % M;
        } else if (a2 < a1 && a2 < a3) {
            a = a2;
            pos = x;
        } else if (a3 < a1 && a3 < a2) {
            a = a3;
            pos = (x + 1) % M;
        } else if (a1 == a2 && a3 < a1) {
            a = a3;
            pos = (x + 1) % M;
        } else if (a1 == a2 && a3 > a1) {
            if (m[(x - 1 + M) % M][y + 1] > m[x][y + 1]) {
                a = a2;
                pos = x;
            } else if (m[(x - 1 + M) % M][y + 1] < m[x][y + 1]) {
                a = a1;
                pos = (x - 1 + M) % M;
            } else {
                a = a1;
                pos = Math.min(x, (x - 1 + M) % M);
            }
        } else if (a1 == a3 && a2 < a1) {
            a = a2;
            pos = x;
        } else if (a1 == a3 && a2 > a1) {
            if (m[(x - 1 + M) % M][y + 1] > m[(x + 1) % M][y + 1]) {
                a = a3;
                pos = (x + 1) % M;
            } else if (m[(x - 1 + M) % M][y + 1] < m[(x + 1) % M][y + 1]) {
                a = a1;
                pos = (x - 1 + M) % M;
            } else {
                a = a1;
                pos = Math.min((x - 1 + M) % M, (x + 1) % M);
            }
        } else if (a2 == a3 && a1 < a2) {
            a = a1;
            pos = (x - 1 + M) % M;
        } else if (a2 == a3 && a1 > a2) {
            if (m[x][y + 1] > m[(x + 1) % M][y + 1]) {
                a = a3;
                pos = (x + 1) % M;
            } else if (m[x][y + 1] < m[(x + 1) % M][y + 1]) {
                a = a2;
                pos = x;
            } else {
                a = a2;
                pos = Math.min((x + 1) % M, x);
            }
        } else {
            a = a1;
            pos = Math.min(x, Math.min((x + 1) % M, (x - 1 + M) % M));
        }
        //guardar el path;;
        path[x][y] = pos;
        return memo[x][y] = a + m[x][y];

    }

    public static void getPath(int x, int y) {
        if (y == N) {
            ts.add(ss.toString());
        } else {
            ss.append(x + 1).append(" ");
            getPath(path[x][y], y + 1);
        }


    }

    public static void main(String args[]) throws Exception {
       BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (br.ready()) {
            String line[] = br.readLine().split("[ ]+");
            M = Integer.parseInt(line[0]);
            N = Integer.parseInt(line[1]);

            String ll = br.readLine();
            StringTokenizer st = new StringTokenizer(ll);
            while (st.countTokens() != M * N) {
                ll += " " + br.readLine();
                st = new StringTokenizer(ll);
                // System.out.println("tkns:" + st.countTokens());

            }

            // System.out.println("pasa");


            m = new int[M][N];
            path = new int[M][N];
            memo = new int[M][N];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    memo[i][j] = -1;
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    m[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < M; i++) {
                //  System.out.println("pasa");
                min = Math.min(path(i, 0), min);
            }

            /*
             * for (int i = 0; i < M; i++) {
             * System.out.println(Arrays.toString(m[i])); }
             * System.out.println("-------"); for (int i = 0; i < M; i++) {
             * System.out.println(Arrays.toString(path[i])); }
             *
             * System.out.println("-------"); for (int i = 0; i < M; i++) {
             * System.out.println(Arrays.toString(memo[i]));
            }
             */
            ss = new StringBuilder();


            ts = new TreeSet<String>();
            for (int i = 0; i < M; i++) {
                if (memo[i][0] == min) {
                    getPath(i, 0);
                }
            }
            for (String gg : ts) {
                System.out.println(gg.trim());
                break;
            }
            System.out.println(min);


        }
    }
}
