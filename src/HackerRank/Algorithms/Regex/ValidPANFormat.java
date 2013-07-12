/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.Algorithms.Regex;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ValidPANFormat {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pattern = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(pattern);


        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (p.matcher(br.readLine().trim()).find()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}