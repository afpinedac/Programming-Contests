package UvaHunting.SolvingParadigms.Greedy;

//package programming;

import java.io.*;
import java.util.*;

public class X_shell_sort {

    public static boolean isSolution() {
        for (int i = 0; i < n; i++) {
            if (a2.get(i) != i) {
                return false;
            }
        }
        return true;
    }
    static String[] a1;
    static ArrayList<Integer> a2;
    static HashMap<String, Integer> hm2;
    static HashMap<Integer, String> hm22;
    static int n;

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            hm2 = new HashMap<String, Integer>();
            hm22 = new HashMap<Integer, String>();
            a1 = new String[n];
            a2 = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a1[i] = br.readLine();
            }
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                hm2.put(str, i);
                hm22.put(i, str);
            }
            for (String s : a1) {
                a2.add(hm2.get(s));
            }


            ArrayList<Integer> sol = new ArrayList<Integer>();
            while (!isSolution()) {
                for (int i = 0; i < n; i++) {
                    if (a2.get(i) != i) {
                        int up = a2.get(i) - 1;
                        a2.remove((Integer) up);
                        a2.add(0, up);
                        sol.add(up);
                        break;
                    }
                }
            }
            for (int i : sol) {
                System.out.println(hm22.get(i));
            }
            if (br.ready()) {
                System.out.println("");
            }
        }
    }
}
