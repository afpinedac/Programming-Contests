/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.Algorithms.Regex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankTweets {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int s = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine().toLowerCase().trim();
            Pattern p = Pattern.compile("hackerrank");
            Matcher m = p.matcher(line);
            while (m.find()) {                
                s++;
            }
        }
        System.out.println(s);


    }
}
