package UvaHunting.Introduction.Josephus;


import java.io.*;
import java.util.*;

public class PowerCrisis {

    static boolean used[];
    static int N;
    static int curr_pos;
    static int m;

    public static void restart() {
        used = new boolean[N];
        curr_pos = 0;
    }

    public static void kill_next() {
        int steps = 0;
        while (steps < m) {
            curr_pos = (++curr_pos) % N;
            if (!used[curr_pos]) {
                steps++;
            }
        }
        //  System.out.println("killed: " + curr_pos);

        used[curr_pos] = true;

    }

    public static boolean check_sol() {
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws Exception {
    //    BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            curr_pos = 0;
            m = 0;
            while (true) {
                m++;
                restart();
                //        System.out.println("startint new M: " + m  );
                used[0] = true;
                while (!used[12]) {
                    kill_next();
                }
                if (check_sol()) {
                    break;
                }

            }
            System.out.println(m);
        }
    }
}