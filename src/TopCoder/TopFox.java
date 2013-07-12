import java.util.*;

public class TopFox {
    public int possibleHandles(String familyName, String givenName) {
        TreeSet<String> handlers = new TreeSet<String>();
        int n=familyName.length();
        int m=givenName.length();
        
        for (int i = 1; i <= n; i++) {
           String h= familyName.substring(0,i);
            for (int j = 1; j <= m; j++) {
                String handle = h + givenName.substring(0,j);            
                handlers.add(handle);
            }
        }  
        return  handlers.size();
       
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TopFox.class, "test.*");
    }

	public void test0() {
		RETester.eq(possibleHandles("ab", "cd"), 4);
	}

	public void test1() {
		RETester.eq(possibleHandles("abb", "bbc"), 7);
	}

	public void test2() {
		RETester.eq(possibleHandles("fox", "ciel"), 12);
	}

	public void test3() {
		RETester.eq(possibleHandles("abbbb", "bbbbbbbc"), 16);
	}

	public void test4() {
		RETester.eq(possibleHandles("abxy", "xyxyxc"), 21);
	}

	public void test5() {
		RETester.eq(possibleHandles("ababababab", "bababababa"), 68);
	}

// END CUT HERE
}

