/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.Algorithms.Regex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 *
 * @author AndresPineda
 */
public class SayingHI {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String pattern = "^((h|H)(i|I))\\s+[^(d|D)]";
        Pattern p = Pattern.compile(pattern);
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            if (p.matcher(line).find() || line.equals("hi")) {
                System.out.println(line);
            }
        }
        
    }
}
