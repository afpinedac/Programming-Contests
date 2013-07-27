package UvaHunting.DataStructures.TreeMap;

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class P_HardowoodSpecies {

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));

        int n = Integer.parseInt(br.readLine());
        br.readLine();

        TreeMap<String, Float> tm;
        DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
        DecimalFormat formateador = new DecimalFormat("####.####", simbolos);
        String s;
        float c, suma;
        StringBuilder sb;
        while (n-- > 0) {
            tm = new TreeMap<String, Float>();
            c = 0;
            while ((s = br.readLine()) != null) {
                if (s.equals("")) {
                    break;
                }
                c++;
                tm.put(s, tm.containsKey(s) ? tm.get(s) + 1 : 1);
            }

            suma = 0;
            sb = new StringBuilder();
            for (Map.Entry<String, Float> m : tm.entrySet()) {
                sb.append(m.getKey()).append(" ").append(formateador.format((m.getValue() / c) * 100)).append("\n");
            }
            System.out.println(sb.toString().trim());

            if (n > 0) {
                System.out.println("");
            }
        }
    }
}
