package UvaHunting.SolvingParadigms.Iterativo2Loop;

import java.io.*;
import java.util.*;

public class Division {

    static ArrayList<String> result;
    static boolean used[];

    public static void backtrack(int values[], int level) {
        if (level == 5) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                sb.append(values[i]);
            }
            result.add(sb.toString());
        } else {
            for (int i = 0; i < 10; i++) {
                if (!used[i]) {
                    used[i] = true;
                    values[level] = i;
                    backtrack(values, level + 1);
                    used[i] = false;
                }
            }
        }
    }

    public static boolean valid(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean valido(String str, int N) {
        if (N > 98765) {
            return false;
        }
        String r = "" + N;
        r = (r.length() == 4) ? "0" + r : r;
        if (!valid(r)) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (str.contains("" + r.charAt(i))) {
                return false;
            }
        }


        return true;
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opc[] = new int[10];

        for (int i = 0; i <= 9; i++) {
            opc[i] = i;
        }
        result = new ArrayList<String>();
        used = new boolean[10];
        backtrack(new int[5], 0);
        
        int N = Integer.parseInt(br.readLine());
        while (true) {
            TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
            if (N == 0) {
                break;
            }
            boolean found = false;
            int l = result.size();
            for (int i = 0; i < l; i++) {
                String V = (result.get(i));
                if (valido(V, Integer.parseInt(V) * N)) {
                    found = true;
                    tm.put(Integer.parseInt(V) * N, V);
                }
            }

            if (!found) {
                System.out.println("There are no solutions for " + N + ".");
            } else {
                for (Map.Entry<Integer, String> datos : tm.entrySet()) {
                    String value = "" + datos.getKey();
                    value = (value.length() == 4) ? "0" + value : value;
                    System.out.println(value + " / " + datos.getValue() + " = " + N);
                }
            }

            N = Integer.parseInt(br.readLine());
            if (br.ready()) {
                System.out.println();
            }
        }




    }
}
