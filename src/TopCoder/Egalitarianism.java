
import java.util.*;

public class Egalitarianism {

    int max;
    boolean visited[];
    int n;
    String isF[];

    public boolean connected() {       
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public int maxDifference(String[] isFriend, int d) {

        isF = isFriend;
        n = isFriend.length;
        max = 0;
        boolean one=false;
        
        //System.out.println(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isFriend[i].charAt(j) == 'Y') {
                    one = true;
                    visited = new boolean[n];                    
                    dfs(i, 0);
                    if (!connected()) {
                        return -1;
                    }
                }
            }
        }
        
        if(!one) return -1;
        System.out.println("max " + max);

        return max * d;

    }

    private void dfs(int i, int level) {
        visited[i] = true;
        max = Math.max(max, level);
        for (int j = 0; j < n; j++) {
            if (isF[i].charAt(j) == 'Y' && !visited[j]) {
                dfs(j, level + 1);
            }
        }


    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Egalitarianism.class, "test.*");
    }

    public void test0() {
        RETester.eq(maxDifference(new String[]{
            "NYN",
            "YNY",
            "NYN"},
                10), 20);
    }

    public void test1() {
        RETester.eq(maxDifference(new String[]{
            "NN",
            "NN"},
                1), -1);
    }

    public void test2() {
        RETester.eq(maxDifference(new String[]{
            "NNYNNN",
            "NNYNNN",
            "YYNYNN",
            "NNYNYY",
            "NNNYNN",
            "NNNYNN"},
                1000), 3000);
    }

    public void test3() {
        RETester.eq(maxDifference(new String[]{
            "NNYN",
            "NNNY",
            "YNNN",
            "NYNN"},
                584), -1);
    }

    public void test4() {
        RETester.eq(maxDifference(new String[]{
            "NYNYYYN",
            "YNNYYYN",
            "NNNNYNN",
            "YYNNYYN",
            "YYYYNNN",
            "YYNYNNY",
            "NNNNNYN"},
                5), 20);
    }

    public void test5() {
        RETester.eq(maxDifference(new String[]{
            "NYYNNNNYYYYNNNN",
            "YNNNYNNNNNNYYNN",
            "YNNYNYNNNNYNNNN",
            "NNYNNYNNNNNNNNN",
            "NYNNNNYNNYNNNNN",
            "NNYYNNYNNYNNNYN",
            "NNNNYYNNYNNNNNN",
            "YNNNNNNNNNYNNNN",
            "YNNNNNYNNNNNYNN",
            "YNNNYYNNNNNNNNY",
            "YNYNNNNYNNNNNNN",
            "NYNNNNNNNNNNNNY",
            "NYNNNNNNYNNNNYN",
            "NNNNNYNNNNNNYNN",
            "NNNNNNNNNYNYNNN"},
                747), 2988);
    }

    public void test6() {
        RETester.eq(maxDifference(new String[]{
            "NY",
            "YN"},
                0), 0);
    }
// END CUT HERE
}
