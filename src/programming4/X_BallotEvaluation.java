package programming;

import java.io.*;
import java.util.*;

public class X_BallotEvaluation {

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line[] = br.readLine().split("[ ]+");
        int P = Integer.parseInt(line[0]);
        int G = Integer.parseInt(line[1]);
        HashMap<String, Float> tm = new HashMap<String, Float>();

        for (int i = 0; i < P; i++) {
            String xx[] = br.readLine().split("[ ]+");
            tm.put(xx[0], Float.parseFloat(xx[1]));
        }

        //conjeturas
        String[] xx;
        int total;
        float suma;
        boolean valid;
        for (int i = 0; i < G; i++) {
            xx = br.readLine().split("[ ]+");
            suma = 0;
            // System.out.println(Arrays.toString(xx));

            for (int j = 0; j < xx.length - 2; j++) {
                if (j % 2 == 0) {
                    suma += tm.get(xx[j]);
                }
            }

            String op = xx[xx.length - 2];
            total = Integer.parseInt(xx[xx.length - 1]);

            valid = false;
            if (op.equals(">")) {
                if (suma > total) {
                    valid = true;
                }
            } else if (op.equals("<")) {
                if (suma < total) {
                    valid = true;
                }
            } else if (op.equals("<=")) {
                if (suma <= total) {
                    valid = true;
                }
            } else if (op.equals(">=")) {
                if (suma >= total) {
                    valid = true;
                }
            } else if (op.equals("=")) {
                if (suma == total) {
                    valid = true;
                }
            }
            System.out.println((valid) ? "Guess #" + (i + 1) + " was correct." : "Guess #" + (i + 1) + " was incorrect.");

        }
    }
}