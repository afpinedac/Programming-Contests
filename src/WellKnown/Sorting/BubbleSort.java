package WellKnown.Sorting;

import java.util.Arrays;


/*
 Complejidad O(n^2)
 */


public class BubbleSort {

    public static void bubbleSort(int a[]) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                }
            }
        }

    }

    public static void main(String[] args) {
        int a[] = {1, -34, 43, 3, 43};

        bubbleSort(a);
        System.out.println(Arrays.toString(a));


    }
}
