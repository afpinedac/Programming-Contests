package programming;

import java.io.*;
import java.util.*;

public class StringPopping {

    public static class point {

        int x;
        int y;

        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<point> ts;

    public static void getS(String s, ArrayList<point> tt) {
        char c[] = s.toCharArray();
        int ini = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] != c[i + 1]) {
                tt.add(new point(ini, i));
                ini = i + 1;
            }
        }
        if (c[ini] == c[c.length - 1]) {
            tt.add(new point(ini, c.length - 1));
        }
    }
    static boolean llego;

    public static void backtrack(String str) {
        if (str.equals("")) {
            llego = true;
        } else if (str.equals("aa") || str.equals("bb") || str.equals("a") || str.equals("b") || str.length() > 2) {
            ArrayList<point> tt = new ArrayList<point>();
            getS(str, tt);
            for (point p : tt) {
                if (!llego) {
                    StringBuilder sb = new StringBuilder(str);
                    if ((p.y + 1 - p.x) >= 2) {
                        backtrack(sb.delete(p.x, p.y + 1).toString());
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String line = br.readLine();
            llego = false;
            backtrack(line);
            System.out.println((llego) ? 1 : 0);

        }
    }
}
