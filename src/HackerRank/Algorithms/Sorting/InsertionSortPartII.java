/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.Algorithms.Sorting;

import java.util.*;

public class InsertionSortPartII {
    
    public static void insertionSort(int[] ar) {
        int n = ar.length;
        
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && ar[j] < ar[j - 1]) {
                int aux = ar[j];
                ar[j] = ar[j - 1];
                ar[j - 1] = aux;
                j--;
            }
            printArray(ar);
        }
        
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
        insertionSort(ar);
    }
}