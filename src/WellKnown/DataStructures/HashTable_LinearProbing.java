package WellKnown.DataStructures;

import java.util.Iterator;

public class HashTable_LinearProbing {

    static class DataItem {

        int data;

        DataItem(int data) {
            this.data = data;
        }

        public int get_key() {
            return data;
        }
    }

    static class HashTable {

        DataItem[] hash_array;
        int _size;
        DataItem non_item;

        public HashTable(int _size) {
            this._size = _size;
            hash_array = new DataItem[_size];
            non_item = new DataItem(-1);
        }

        public void display_table() {
            System.out.println("Printing the table: ");
            for (int i = 0; i < hash_array.length; i++) {
                if (hash_array[i] != null) {
                    System.out.println(hash_array[i].get_key());
                } else {
                    System.out.println("**");
                }
            }

        }

        public int hash_function(int key) {
            return key % _size;
        }

        public void insert(DataItem item) {
            int key = item.get_key();
            int pos = hash_function(key);

            while (hash_array[pos] != null && hash_array[pos].get_key() != -1) {
                pos = ++pos % _size;
            }
            hash_array[pos] = item;
        }
    }
}
