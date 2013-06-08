package programming;

import java.io.*;
import java.util.*;

public class BudgetTravel {

    static float capacity;
    static float dxg;
    static float M[][];
    static double min;
    static int cities;

    public static void backtrack(int k, float cost, float current) {
        if (k == cities + 1) {
            min = Math.min(cost, min);
        } else {
            float gasto = (M[k + 1][0] - M[k][0]) / dxg;
            if (current < gasto) {
                float lack = capacity - current;
                backtrack(k + 1, cost + (lack * M[k][1]) / 100.0f + 2.0f, capacity - gasto);
            } else {
                if (current > (0.5 * capacity)) {
                    backtrack(k + 1, cost, current - gasto);
                } else {
                    //recargo
                    float lack = capacity - current;
                    backtrack(k + 1, cost + (lack * M[k][1]) / 100.0f + 2.0f, capacity - gasto);
                    // no reacargo
                    backtrack(k + 1, cost, current - gasto);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = 1;
        while (true) {
            float distance = Float.parseFloat(br.readLine());
            if (distance == -1.0) {
                break;
            }
            String values[] = br.readLine().split("[ ]+");
            capacity = Float.parseFloat(values[0]);
            dxg = Float.parseFloat(values[1]);
            float cost = Float.parseFloat(values[2]);
            cities = Integer.parseInt(values[3]);
            M = new float[cities + 2][2];

            for (int i = 1; i <= cities; i++) {
                String line[] = br.readLine().split("[ ]+");
                M[i][0] = Float.parseFloat(line[0]);
                M[i][1] = Float.parseFloat(line[1]);
            }
            M[cities + 1][0] = distance;
            min = Double.MAX_VALUE;
            backtrack(0, cost, capacity);

            System.out.println("Data Set #" + (t++));
            System.out.printf(Locale.ENGLISH, "minimum cost = $%.2f\n", min);

        }




    }
}