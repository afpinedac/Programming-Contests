package HackerRank.Algorithms.Regex;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindhackerRank {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern start_end = Pattern.compile("^(hackerrank)[\\w\\s]*(hackerrank)$");
        Pattern start = Pattern.compile("^hackerrank");
        Pattern end = Pattern.compile("hackerrank$");
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            if (start_end.matcher(line).find() || line.equals("hackerrank")) {
                System.out.println("0");
            } else if (start.matcher(line).find()) {
                System.out.println("1");
            } else if (end.matcher(line).find()) {
                System.out.println("2");
            } else {
                System.out.println("-1");
            }
        }
    }
}
