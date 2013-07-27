
import java.util.*;

public class LISNumberDivTwo {

    public int calculate(int[] seq) {

        int c = 0;
        for (int i = 0; i < seq.length - 1; i++) {
            if (seq[i] >= seq[i + 1]) {
                c++;
            }
        }
        return c + 1;

    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(LISNumberDivTwo.class, "test.*");
    }

    public void test0() {
        RETester.eq(calculate(new int[]{1, 4, 4, 2, 6, 3}), 4);
    }

    public void test1() {
        RETester.eq(calculate(new int[]{5, 8, 9, 12, 16, 32, 50}), 1);
    }

    public void test2() {
        RETester.eq(calculate(new int[]{1, 1, 9, 9, 2, 2, 3, 3}), 6);
    }

    public void test3() {
        RETester.eq(calculate(new int[]{50, 40, 30, 20, 10}), 5);
    }

    public void test4() {
        RETester.eq(calculate(new int[]{42}), 1);
    }
// END CUT HERE
}
