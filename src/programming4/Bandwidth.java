package programming;

import java.io.*;
import java.util.*;

public class Bandwidth {

    static ArrayList<String> al;
    static int n;
    static char original[];
    static boolean used[];

    public static void allnodes(String str) {
        TreeSet<Character> ts = new TreeSet<Character>();
        int c = str.length();
        for (int i = 0; i < c; i++) {
            if (Character.isLetter(str.charAt(i))) {
                ts.add(str.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = ts.iterator();

        while (it.hasNext()) {
            sb.append(it.next());
        }
        original = sb.toString().toCharArray();
    }

    public static void allPermutations(char b[], int k) {
        if (k == original.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            al.add(sb.toString());
        } else {
            for (int i = 0; i < original.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    b[k] = original[i];
                    allPermutations(b, k + 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String xx = br.readLine();
            if (xx.equals("#")) {
                break;
            }
            al = new ArrayList<String>();
            allnodes(xx);
            used = new boolean[original.length];
            TreeMap<Character, String> tm = new TreeMap<Character, String>();
            String[] line = xx.split(";");
            for (int i = 0; i < line.length; i++) {
                String[] l = line[i].split(":");
                tm.put(l[0].charAt(0), l[1]);
            }

            allPermutations(new char[original.length], 0);
            int min = Integer.MAX_VALUE;
            Collections.sort(al);
            String g = "";
            String res = "";
            for (String str : al) {
               
                //  System.out.println(str);
                int max = 0;
                for (Map.Entry<Character, String> datos : tm.entrySet()) {
                    char c = datos.getKey();
                    String s = datos.getValue();
                    int l = s.length();

                    int i1 = str.indexOf(c);
                    for (int i = 0; i < l; i++) {
                        int i2 = str.indexOf(s.charAt(i));
                        if (Math.abs(i2 - i1) > max) {
                            max = Math.abs(i2 - i1);
                            res = str;
                        }
                    }
                }
                if (max < min) {
                    min = max;
                    g = res;
                }
            }
            for (int i = 0; i < g.length(); i++) {
                System.out.print(g.charAt(i) + " ");
            }
            System.out.println("-> " + min);
        }
    }
}