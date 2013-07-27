
import java.util.*;

public class TrafficCongestionDivTwo {

    public long theMinCars(int treeHeight) {
        long res;
       // long test = (long) Math.pow(2, treeHeight + 1) - 1;
        //  System.out.println("x = " + treeHeight);
        // System.out.println("x = " + test);

        res = (long) Math.ceil(((Math.pow(2, treeHeight + 1) - 1) / 3));

        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TrafficCongestionDivTwo.class, "test.*");
    }

    public void test0() {
        RETester.eq(theMinCars(1), 1L);
    }

    public void test1() {
        RETester.eq(theMinCars(2), 3L);
    }

    public void test2() {
        RETester.eq(theMinCars(3), 5L);
    }

    public void test3() {
        RETester.eq(theMinCars(10), 683L);
    }

    public void test4() {
        RETester.eq(theMinCars(60), 768614336404564651L);
    }
// END CUT HERE
}
