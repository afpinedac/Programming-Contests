package HackerRank.Algorithms.Regex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UKandUSA {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String w[] = new String[n];
        for (int i = 0; i < n; i++) {
            w[i] = br.readLine().trim();
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int s = 0;
            String word = br.readLine().trim();
            String pattern = word.substring(0, word.length() - 2) + "[s|z]e";
            Pattern p = Pattern.compile(pattern);
            for (int j = 0; j < n; j++) {
                Matcher m = p.matcher(w[j]);
                while (m.find()) {
                    s++;
                }

            }
            System.out.println(s);
        }


    }
}
