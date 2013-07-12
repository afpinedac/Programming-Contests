package WellKnown.Sorting;

import java.util.Arrays;
import java.util.TreeSet;

public class QuickSort1 {

    static int arr[] = {3, 5, 8, 4, 2, 9, 6};

    //the problem of take the lastone is that probably there is the greater or lower value , so 
    //it make the algorithm makes two division in N-1 and 1 value, it will degenerate the algorithm to O(N^2)
    static void swap(int i, int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    static int partition(int x, int y, int pivot) {  //se recibe el pivote
        int right = y;
        int l = x - 1;
        int r = y;
        while (true) {
            while (arr[++l] < pivot);
            while (r > 0 && pivot < arr[--r]);
            if (l >= r) {  // cuando el puntero izquierdo sobrepasa al derecho, es que no encontro un valor mayor a la izquierda ni uno menor a la derecha
                break;
            } else {
                swap(l, r);  // intercambie los valores
            }
        }
        swap(l, right); //cambiamos el pivote , la posicion left ahora va a ser el pivote que estaba a la derecha
        return l;

    }

    static void qs(int l, int r) {
        if (r - l <= 0) {
            return;
        }
        int pivot = arr[r];
        int partition = partition(l, r, pivot);
        qs(l, partition - 1);
        qs(partition + 1, r);



    }

    public static void main(String[] args) throws Exception {
        qs(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
