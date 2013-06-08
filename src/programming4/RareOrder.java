package programming;

import java.io.*;
import java.util.*;

public class RareOrder {

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        char M[][] = new char[10000][20];
        String line;
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                M[idx][i] = line.charAt(i);
            }
            idx++;
        }
        ArrayList<Character> al = new ArrayList<Character>();
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < idx; i++) {
                char c = M[i][j];
                if (Character.isLetter(c) && !al.contains(c)) {
                    al.add(c);
                }
            }
        }
        for (char c : al) {
            System.out.print(c);
        }
        System.out.print("\n");
    }
}
