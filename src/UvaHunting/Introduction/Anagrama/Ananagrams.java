package UvaHunting.Introduction.Anagrama;

import java.io.*;
import java.util.*;
import java.math.*;

public class Ananagrams {

    static TreeSet<String> response = new TreeSet<String>();
    static HashMap<String, Integer> dictionary = new HashMap<String, Integer>();

    static void add_dictionary(String s) {
        char c[] = s.toLowerCase().toCharArray();
        Arrays.sort(c);
        s = String.valueOf(c);

        //  System.out.println("--" + s);
        dictionary.put(s, dictionary.containsKey(s) ? dictionary.get(s) + 1 : 1);
    }

    static boolean in_dictionary(String s) {
        char c[] = s.toLowerCase().toCharArray();
        String x = s;
        Arrays.sort(c);
        s = String.valueOf(c);


        return dictionary.get(s) == 1 ? false : true;

        // return false;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));



        StringBuilder sb = new StringBuilder();
        StringBuilder text = new StringBuilder();

        String s;
        while (true) {
            s = br.readLine();
            if (s.equals("#")) {
                break;
            }
            text.append(s).append(" ");
        }


        StringTokenizer st1 = new StringTokenizer(text.toString());
        StringTokenizer st2 = new StringTokenizer(text.toString());


        while (st1.hasMoreTokens()) {
            add_dictionary(st1.nextToken());
        }

        while (st2.hasMoreTokens()) {
            String t = st2.nextToken();
            if (!in_dictionary(t)) {
                response.add(t);
            }
        }



        for (String r : response) {
            sb.append(r).append("\n");
        }

        System.out.println(sb.toString().trim());




    }
}
