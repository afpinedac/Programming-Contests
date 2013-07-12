package CrackingTheCode;

import java.util.BitSet;

public class E1_1 {

    /*
     * Preguntas: Es unicode o ASCII 
     * 
     */
    
    
    
    /*  Implement an algorithm to determine if a string has all unique characters. What
     if you cannot use additional data structures?
     */
    // it is the best approach due the use of memory and time
    public static boolean uniqueCharacters2(String s) {
        boolean used[] = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (used[c]) {
                return false;
            }
            used[c] = true;
        }


        return true;
    }

    public static void main(String[] args) {
        String s = "ab";

        System.out.println(uniqueCharacters2(s));


    }
}
