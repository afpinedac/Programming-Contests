/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.Algorithms.Sorting;
//RunningTimeofAlgorithms

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningTimeofAlgorithms {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        String line[] = br.readLine().trim().split("[ ]+");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        int c = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                c++;
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }
        System.out.println(c);



    }
}
