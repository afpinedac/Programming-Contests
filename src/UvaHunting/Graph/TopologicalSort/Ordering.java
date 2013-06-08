package UvaHunting.Graph.TopologicalSort;

import java.io.*;
import java.util.*;

public class Ordering {

    static void swap(char[] c, int i, int j) {
        char t = c[ i];
        c[ i] = c[ j];
        c[ j] = t;
    }

    static boolean nextPermutation(char[] c) {
        int n = c.length;
        int k = -1;
        for (int i = n - 2; i >= 0; --i) {
            if (c[ i] < c[ i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return false;
        }
        int l = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (c[ k] < c[ i]) {
                l = i;
                break;
            }
        }
        swap(c, k, l);
        for (int i = k + 1; i < (n + k + 1) / 2; ++i) {
            swap(c, i, n + k - i);
        }
        return true;
    }
    static TreeSet<String> ts;

    public static boolean checkAll(char c[]) {
        StringBuilder ss = new StringBuilder();
        ss.append(c);
        String st = ss.toString();
        for (String str : ts) {
            if (st.indexOf(str.charAt(0)) > st.indexOf(str.charAt(2))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.readLine();
        while (N-- > 0) {
            StringBuilder sb = new StringBuilder();
            char c[] = sb.append(br.readLine()).toString().trim().toCharArray();
            Arrays.sort(c);
            sb=new StringBuilder();
            c = sb.append(c).toString().trim().toCharArray();
         
            
            
            String cons[] = br.readLine().split(" ");
            ts = new TreeSet<String>();
            for (int i = 0; i < cons.length; i++) {
                ts.add(cons[i]);
            }

            boolean found = false;
            sb = new StringBuilder();
            do {
                if (checkAll(c)) {
                    found = true;
                    sb = new StringBuilder();
                    for (int i = 0; i < c.length; i++) {
                        sb.append(c[i]).append(" ");
                    }
                    System.out.println(sb.toString().trim());
                }
            } while (nextPermutation(c));

            if (!found) {
                System.out.println("NO");
            }
            
            if(br.ready()){
                System.out.println();
                br.readLine();
            }

        }


    }
}
