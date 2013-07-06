/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.Algorithms.Sorting;

/* Head ends here */
import java.util.*;

public class InsertionSortPartI {

    static void insertionSort(int[] ar) {
        int pos = 0;
        int n = ar.length;
        int v = ar[n - 1];
        for (pos = 0; pos < n && ar[pos] < v; pos++);
        for (int i = n - 2; i >= 0 && i >= pos; i--) {
            ar[i + 1] = ar[i];
            printArray(ar);
        }
        ar[pos] = v;
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
        insertionSort(ar);


    }
}
