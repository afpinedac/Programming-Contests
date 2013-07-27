package UvaHunting.DataStructures.TreeMap;

import java.io.*;
import java.util.*;
import java.math.*;

public class AndySecondDctionary {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));

        List<Integer> delete = new ArrayList<Integer>();


        int c = 0;
        String s;
        StringBuilder sb = new StringBuilder();
        boolean hyped = false;

        while ((s = br.readLine()) != null) {
            if (s.equals("")) {
                if (hyped) {
                    delete.remove(delete.size() - 1);
                    c++;
                    sb.append(" ");
                }
                continue;
            }
            if (s.charAt(s.length() - 1) == '-') {
                c += s.length();
                delete.add(c);
                sb.append(s.toLowerCase());
                hyped = true;

            } else {
                hyped = false;
                sb.append(s.toLowerCase()).append(" ");
                c += s.length() + 1;
            }
        }
        if (hyped) {
            delete.remove(delete.size() - 1);
        }


        for (int i = 0; i < delete.size(); i++) {
            sb.deleteCharAt(delete.get(i) - 1 - i);
        }
        // System.out.println(sb);


        String[] w = sb.toString().split("[^a-z\\-]+");

        TreeSet<String> ts = new TreeSet<String>();
        for (String st : w) {
            ts.add(st);
        }

        StringBuilder sbd = new StringBuilder();

        for (String st : ts) {
            sbd.append(st).append("\n");
        }
        System.out.println(sbd.toString().trim());

    }
}
