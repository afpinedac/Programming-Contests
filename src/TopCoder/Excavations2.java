
import java.util.*;

public class Excavations2 {

    public long count(int[] kind, int[] found, int K) {
         int n = kind.length;
         
        
        return -1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Excavations2.class, "test.*");
    }

    public void test0() {
        RETester.eq(count(new int[]{1, 2, 2, 1}, new int[]{1}, 2), 1L);
    }

    public void test1() {
        RETester.eq(count(new int[]{1, 2, 2, 1}, new int[]{1, 2}, 2), 4L);
    }

    public void test2() {
        RETester.eq(count(new int[]{1, 2, 1, 1, 2, 3, 4, 3, 2, 2}, new int[]{4, 2}, 3), 6L);
    }

    public void test3() {
        RETester.eq(count(new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50}, new int[]{50}, 21), 5567902560L);
    }
// END CUT HERE
}
