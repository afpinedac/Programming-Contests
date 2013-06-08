package programming4;

import java.io.*;
import java.util.*;

public class Recycling {

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.charAt(0) == '#') {
                break;
            }
            String[][] M = new String[100][5];
            int index = 0;
            while (true) {
                if (line.charAt(0) == 'e') {
                    break;
                }
                M[index++] = line.split(",");
                Arrays.sort(M[index - 1]);
                line = br.readLine();
            }

            //procesamiento
            int result[][] = new int[index][5];
            TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < index; i++) {
                    tm.put(M[i][j], tm.containsKey(M[i][j]) ? tm.get(M[i][j]) + 1 : 1);
                }
            }

           
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < index; i++) {
                    result[i][j] = tm.get(M[i][j]);
                }
            }
            int vec[] = new int[index];
            for (int i = 0; i < index; i++) {
                int s = 0;
                for (int j = 0; j < 5; j++) {
                    s += result[i][j];
                }
                vec[i] = s;
            }
            int max = 0;
            int im = 0;
            for (int i = 0; i < index; i++) {
                if (vec[i] > max) {
                    max = vec[i];
                    im = i;
                }
            }
            System.out.println(++im);
        }


    }
}