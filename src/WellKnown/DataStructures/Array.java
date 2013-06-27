package WellKnown.DataStructures;


/*                DUPLICATES            NO DUPLICATES
 * insertion :    no moves              no moves
 * deletion :     more than N/2         N/2 moves
 * search :       N comparison          N/2 comparison
 * 
 */
public class Array {

    private long a[];
    private int nElemens;

    public Array(int size) {
        a = new long[10];
        nElemens = 0;
    }

    private int find(long value) {
        for (int i = 0; i < nElemens; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }
    

    public void add(int value) {
        a[nElemens++] = value;
    }

    public boolean remove(long value) {
        int pos = find(value);

        if (pos == -1) {
            return false;
        }
        for (int i = pos; i < nElemens - 1; i++) {
            a[i] = a[i + 1];
        }
        nElemens--;
        return true;
    }

    public void display() {
        for (int i = 0; i < nElemens; i++) {
            System.out.println(a[i]);
        }
        System.out.println("---");
    }

    public static void main(String[] args) {
        Array a = new Array(5);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.remove(3);
        a.display();
        a.remove(2);
        a.display();
        a.remove(1);
        a.display();
        a.remove(5);
        a.display();



    }
}
