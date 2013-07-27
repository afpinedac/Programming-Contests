package UvaHunting.String.OutputFormatting;

import java.io.*;
import java.util.*;
import java.math.*;

public class RotatingSentences {

    static ArrayList<String> words = new ArrayList<String>();
    static char M[][];
    static int l[];

    static void set(String s, int j) {
        for (int i = 0; i < s.length(); i++) {
            M[i][j] = s.charAt(i);
        }
    }

    static boolean hay_char(int i, int j, int n) {
        char c[] = new char[1];
        for (int k = j; k < n; k++) {
            if (M[i][k] != c[0]) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));

        int m = 0;
        while (br.ready()) {
            String s = br.readLine();
            words.add(s);
            m = Math.max(m, s.length());
        }

        M = new char[m][words.size()];
        l = new int[words.size()];
        for (int i = 0; i < words.size(); i++) {
            l[i] = words.get(i).length();
        }

        for (int i = 0; i < words.size(); i++) {
            set(words.get(i), words.size() - i - 1);
        }


        StringBuilder sb = new StringBuilder();

        char a[] = new char[1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < words.size(); j++) {

                if (M[i][j] != a[0]) {
                    sb.append(M[i][j]);
                } else {
                    if (hay_char(i, j, words.size())) {
                        sb.append(" ");
                    }
                }
            }
            if (i + 1 != m) {
                sb.append("\n");
            }

        }
        System.out.println(sb.toString());

    }
}
