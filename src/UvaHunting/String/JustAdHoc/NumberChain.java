package UvaHunting.String.JustAdHoc;

import java.io.*;
import java.util.*;
import java.math.*;

public class NumberChain {

    static String sort(String s, boolean reverse) {
        char c[] = s.toCharArray();
        Arrays.sort(c);
        if (reverse) {
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            return sb.reverse().toString();

        } else {
            return String.valueOf(c);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        boolean first = true;

        while (true) {
            Long n = Long.parseLong(br.readLine());

            if (n == 0) {
                break;
            }

           

            StringBuilder sb = new StringBuilder("Original number was ");
            sb.append(n).append("\n");

            HashSet<String> hs = new HashSet<String>();
            String total = "-1";
            while (!hs.contains(total)) {
                hs.add(total);
                long ordered = Long.parseLong(sort("" + n, false));
                long reverse = Long.parseLong(sort("" + n, true));              
                n = (reverse - ordered);
                sb.append(reverse).append(" - ").append(ordered).append(" = ").append(n).append("\n");              
                total = "" + n;

            }
            sb.append("Chain length ").append(hs.size()).append("\n");
            System.out.println(sb.toString());
        }

    }
}
