package UvaHunting.DataStructures.TreeMap;

import java.io.*;
import java.util.*;

public class BallotEvaluation {

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        HashMap<String, Float> tm = new HashMap<String, Float>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            tm.put(st.nextToken(), Float.parseFloat(st.nextToken()) * 10);

        }

        //conjeturas


        int total;
        float suma;
        boolean valid;
        String op;
        StringBuilder sb = new StringBuilder();
        int tokens;

        for (int i = 1; i <= G; i++) {
            sb.append("Guess #").append(i).append(" was ");
            st = new StringTokenizer(br.readLine());
            tokens = st.countTokens();
            suma = 0;
            for (int j = 0; j < tokens - 2; j++) {
                if (j % 2 == 0) {
                    suma += tm.get(st.nextToken());
                } else {
                    st.nextToken();
                }
            }

            op = st.nextToken();
            total = Integer.parseInt(st.nextToken()) * 10;

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

            if (valid) {
                sb.append("correct.");
            } else {
                sb.append("incorrect.");
            }
            sb.append("\n");


        }
        System.out.println(sb.toString().trim());
    }
}