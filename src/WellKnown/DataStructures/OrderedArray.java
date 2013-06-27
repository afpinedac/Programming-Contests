package WellKnown.DataStructures;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderedArray {

    long a[];
    int nElems;

    public OrderedArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public void add(long value) {
        int i, j;
        for (i = 0; i < nElems; i++) {
            if (value < a[i]) {
                break;
            }
        }
        for (j = nElems; j > i; j--) {
            a[j] = a[j - 1];
        }
        a[i] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int idx = find(value);
        if (idx > -1) {
            for (int i = idx; i < nElems - 1; i++) {
                a[i] = a[i + 1];
            }
            nElems--;
        }
        return false;
    }

    public int find(long key) {
        int u = nElems - 1;
        int l = 0;
        while (l <= u) {
            int m = (u + l) >>> 1;
            long value = a[m];
            if (value > key) {
                u = m - 1;
            } else if (value < key) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public void display() {

        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0, nElems)));

    }

    public long getMax() {
        return nElems > 0 ? a[nElems - 1] : -1;
    }

    public void merge(long m[]) {
        for (long a : m) {
            add(a);
        }
    }

    public void noDups() {
       
    }

    public static void main(String[] args) {

        OrderedArray oa = new OrderedArray(10);
        long t[] = {5, 6, 78, 8};

        oa.add(2);
        oa.display();
        oa.add(1);
        oa.display();
        oa.add(7);
        oa.display();
        oa.add(5);
        oa.display();
        oa.delete(1);
        oa.display();
        oa.delete(5);
        oa.display();
        oa.merge(t);
        oa.display();



        System.out.println(oa.getMax());

    }
}
