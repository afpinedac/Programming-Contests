/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.Algorithms.Sorting;

import java.util.*;

public class QuickSort {

    static int arr[];

    static int partition(int l, int r, int pivot) {
        ArrayList<Integer> lower = new ArrayList<Integer>();
        ArrayList<Integer> greater = new ArrayList<Integer>();
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < pivot) {
                lower.add(arr[i]);
            } else {
                greater.add(arr[i]);
            }
        }
        int i = l;
        for (int e : lower) {
            arr[i++] = e;
        }
        int partition = i;
        arr[i++] = pivot;
        for (int e : greater) {
            arr[i++] = e;
        }

        return partition;
    }

    static void qsr(int l, int r) {
        if (r - l <= 0) {
            return;
        } else {
            int partition = partition(l, r, arr[l]);
            qsr(l, partition - 1);
            qsr(partition + 1, r);

            p(l, r);

        }
    }

    static void p(int i, int j) {
        for (int k = i; k <= j; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println("");
    }

    static void quickSort(int[] ar) {
        arr = ar;
        qsr(0, ar.length - 1);

    }

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
        quickSort(ar);
    }
}
