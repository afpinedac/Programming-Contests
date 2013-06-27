package WellKnown.Sorting;

import java.util.Arrays;


/*
 * The complexity is O(n^2)
 * 
 */
public class SelectionSort {

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static void selectionSort(int a[]) {


        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }



    }

    public static void display(int a[]) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 32, 2325, 6, -1};
        selectionSort(a);
        display(a);
    }
}
