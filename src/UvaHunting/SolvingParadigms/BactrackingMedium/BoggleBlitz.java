package programming;

import java.io.*;
import java.util.*;

public class BoggleBlitz {

    static char M[][];
    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean visited[][];
    static TreeSet<String> ts;
    static int N;

    public static boolean valid(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    public static void backtrack(int x, int y, String path) {
        if (path.length() > 2) {
            ts.add(path);
        }
        for (int i = 0; i < 8; i++) {
            int px = x + dx[i];
            int py = y + dy[i];
            if (valid(px, py) && !visited[px][py] && M[px][py] > path.charAt(path.length() - 1)) {
                visited[px][py] = true;
                backtrack(px, py, path + "" + M[px][py]);
                visited[px][py] = false;
            }
        }

    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Comparator<String> cmp = new Comparator<String>() {

            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        };


        int t = Integer.parseInt(br.readLine());
        br.readLine();
        while (t-- > 0) {
            N = Integer.parseInt(br.readLine());
            M = new char[N][N];
            ts = new TreeSet<String>(cmp);
            for (int i = 0; i < N; i++) {
                M[i] = br.readLine().toCharArray();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    visited[i][j] = true;
                    backtrack(i, j, "" + M[i][j]);
                }
            }
            for (String d : ts) {
                System.out.println(d);
            }
            if (br.ready()) {
                br.readLine();
                System.out.println();
            }
        }
    }
}
