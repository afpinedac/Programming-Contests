package UvaHunting.String.JustAdHoc;

import java.io.*;
import java.util.*;
import java.math.*;

public class FindingWords {

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        StringBuilder sb = new StringBuilder();
        List<Integer> hyped = new ArrayList<Integer>();


        int c = -1;
        while (true) {
            String s = br.readLine().trim();
            if (s.equals("#")) {
                break;
            }
            c += s.length();
            if (s.endsWith("-")) {
                hyped.add(c);
            }
            sb.append(s).append("\n");
            c++;
        }
        for (int i : hyped) {

            int start = sb.toString().substring(0, i).lastIndexOf(" ");
            int end = sb.toString().substring(i, sb.toString().length()).indexOf(" ") + i;
            start = start == -1 ? 0 : start + 1;
            end = end == 0 ? sb.toString().length() : end;

            sb.delete(i, i + 2);


            if (start != 0) {
                sb.insert(start, "\n");
            }
            end--;

            if (end - 1 != sb.toString().length()) {
                sb.insert(end, "\n");
            }

        }

        for (int j = 0; j < sb.toString().length(); j++) {
            char ch = sb.toString().charAt(j);
            if (!Character.isLetter(ch) && ch != '\n' && ch != ' ') {
                sb.deleteCharAt(j);
                j--;
            }
        }
        sb.deleteCharAt(sb.toString().length() - 1);
        //  System.out.println("------");
        System.out.println(sb.toString());





    }
}
