package UvaHunting.SolvingParadigms.BactrackingEasy;

import java.io.*;
import java.util.*;

public class X_callforwarding {

    static String M[][];
    static TreeSet<Integer> ts;
    static int idx;

    public static int bactrack(int to, int time) {
        if (ts.contains(to)) {
            return 9999;
        } else {
            String st = respond(to, time);
            if (st.length() == 1) {
                return to;
            } else if (st.equals("0000")) {
                return 9999;
            } else {
                ts.add(to);
                return bactrack(Integer.parseInt(st), time);
            }
        }


    }

    public static String respond(int to, int time) {
        for (int i = 0; i < idx; i++) {
            if (M[i][0].equals("" + to)) {
                int timei = Integer.parseInt(M[i][1]);
                int duration = Integer.parseInt(M[i][2]);
                if (time <= (timei + duration) && time >= timei) {
                    return M[i][3];
                }
            }
        }
        return "0";
    }

    public static void main(String args[]) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 0;
        int N = Integer.parseInt(br.readLine());
        System.out.println("CALL FORWARDING OUTPUT");
        while (N-- > 0) {
            String line;
            idx = 0;
            M = new String[100][4];
            while (!(line = br.readLine()).equals("0000")) {
                M[idx++] = line.split("[ ]+");
            }
            System.out.println("SYSTEM " + (++t));
            while (!(line = br.readLine()).equals("9000")) {
                ts = new TreeSet<Integer>();
                String str[] = line.split("[ ]+");
                int time = Integer.parseInt(str[0]);
                int to = Integer.parseInt(str[1]);

                if (time > 8784) {
                    System.out.println("AT " + str[0] + " CALL TO " + str[1] + " RINGS " + ((str[1].equals("0000") || str[1].equals("9999")) ? "9999" : str[1]));
                } else {
                    System.out.println("AT " + str[0] + " CALL TO " + str[1] + " RINGS " + ((str[1].equals("0000")) ? "9999" : bactrack(to, time)));
                }

            }
        }
        System.out.println("END OF OUTPUT");
    }
}
