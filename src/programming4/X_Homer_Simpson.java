package programming;

import java.io.*;
import java.util.*;

public class X_Homer_Simpson {

    static int m, n, t;
    static int memo[];
    static boolean found;
    static int max;
    static int min;

    public static int time(int time, int eat) {
        if (time < 0) {
            return -100000;
        } else if (time == 0) {
            found = true;          
            max = Math.max(max, eat);
            return 0;
        } else if (memo[time] != -1) {
            return memo[time];
        } else {
            int ans = 0;
            ans = Math.max(ans, time(time - m, eat + 1) + 1);
            ans = Math.max(ans, time(time - n, eat + 1) + 1);
            min=Math.min(min, time);
            return memo[time] = ans;
        }

    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (br.ready()) {
            String line[] = br.readLine().split("[ ]+");
            m = Integer.parseInt(line[0]);
            n = Integer.parseInt(line[1]);
            t = Integer.parseInt(line[2]);
            memo = new int[t + 5];
            Arrays.fill(memo, -1);
            found = false;
            max = 0;
            min=12000000;
            int mm = time(t, 0);
            if(found)System.out.println(max);
            else{
                System.out.println(mm + " " + min);
            }

        }

    }
}
