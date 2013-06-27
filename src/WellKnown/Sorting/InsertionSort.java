package WellKnown.Sorting;

import java.util.Arrays;

public class InsertionSort {
    
    /*
     * Small list and mostly preordered list
     * 
     */

    public static void insertionSort(int a[]) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int j = i ;
            while (j > 0 && a[j-1] > a[j]) {
                int aux = a[j-1];
                a[j-1] = a[j];
                a[j] = aux;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {2,1,0,5,-6};        
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
