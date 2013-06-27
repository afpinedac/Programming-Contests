package CrackingTheCode;

import java.util.BitSet;

public class E1_1 {

    //bad approach due to the size of a integer array it takes a lot of memory
    public static boolean uniqueCharacters(String s) {
        int[] r = new int[256];
        int n = s.length();
        for (int i = 0; i <= n / 2; i++) {
            if (++r[s.charAt(i)] > 1) {
                return false;
            }
            if (++r[s.charAt(n - 1 - i)] > 1) {
                return false;
            }
        }
        return true;
    }

    //Much better because I use less memory 
    public static boolean uniqueCharacters1(String s) {
        BitSet bi = new BitSet(256);
        int n = s.length();
        for (int i = 0; i <= n / 2; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(n - 1 - i);
            if (bi.get(c1) || bi.get(c2)) {
                return false;
            } else {
                bi.set(c1);
                bi.set(c2);
            }
        }


        return true;
    }

    // it is the best approach due the use of memory and time
    public static boolean uniqueCharacters2(String s) {
        boolean used[]=new boolean[256];
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i);
            if(used[c]){
                return false;
            }
            used[c]=true;
        }
        
        
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";

        System.out.println(uniqueCharacters2(s));


    }
}
