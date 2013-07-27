package UvaHunting.Introduction.Anagrama;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static TreeMap<String, ArrayList<String>> tm;

    static void add_dictionary(String s) {
        char c[] = s.toCharArray();
        Arrays.sort(c);
        String t = String.valueOf(c).trim();

        if (tm.containsKey(t)) {
            tm.get(t).add(s);
        } else {
            tm.put(t, new ArrayList<String>());
            tm.get(t).add(s);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));




        int n = Integer.parseInt(br.readLine());
        br.read();
        while (n-- > 0) {
            tm = new TreeMap<String, ArrayList<String>>();
            String s;
            while ((s = br.readLine()) != null) {
                if (s.equals("")) {
                    break;
                }
                add_dictionary(s);
            }


            StringBuilder sb = new StringBuilder();

            TreeSet<String> ts = new TreeSet<String>();


            for (Map.Entry<String, ArrayList<String>> t : tm.entrySet()) {
                ArrayList<String> al = t.getValue();
                Collections.sort(al);
                for (int i = 0; i < al.size() - 1; i++) {
                    for (int j = i + 1; j < al.size(); j++) {
                        ts.add(al.get(i) + " = " + al.get(j));
                        // sb.append(al.get(i)).append(" = ").append(al.get(j)).append("\n");
                    }
                }

            }



            if (!ts.isEmpty()) {
                for (String u : ts) {
                    System.out.println(u);
                }
            }


            if (n > 0) {
                System.out.println("");
            }
        }

    }
}
