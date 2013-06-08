package programming;

import java.io.*;
import java.util.*;

public class Automated_Judge_Script {

    public static String getNumeric(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            String st1 = "";
            while (n-- > 0) {
                st1 += br.readLine() + "\n";
            }
            int m = Integer.parseInt(br.readLine());
            String st2 = "";
            while (m-- > 0) {
                st2 += br.readLine() + "\n";
            }


            if (st1.equals(st2)) {
                System.out.println("Run #" + (t++) + ": Accepted");
            } else {
                //PE
                if (getNumeric(st1).equals(getNumeric(st2))) {
                    System.out.println("Run #" + (t++) + ": Presentation Error");
                } else {
                    System.out.println("Run #" + (t++) + ": Wrong Answer");
                }
            }




        }





    }
}
