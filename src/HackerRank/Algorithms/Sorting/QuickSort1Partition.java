/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.Algorithms.Sorting;

import java.util.*;

public class QuickSort1Partition {

    static void partition(int[] ar) {
        ArrayList<Integer> lower = new ArrayList<Integer>();
        ArrayList<Integer> greater = new ArrayList<Integer>();
        int pivot = ar[0];

        for (int i = 1; i < ar.length; i++) {
            if (ar[i] < pivot) {
                lower.add(ar[i]);
            } else {
                greater.add(ar[i]);
            }
        }     
        int i = 0;
        for (int e : lower) {
            ar[i++] = e;
        }
        ar[i++] = pivot;
        for (int e : greater) {
            ar[i++] = e;
        }
        printArray(ar);
    }

    /* Tail starts here */
    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        partition(ar);
    }
}