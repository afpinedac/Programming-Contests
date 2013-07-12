package CrackingTheCode;

public class E1_3 {

    /*     
     * Preguntas: Is case sensitive? es ASCII or UNICODE
     */
//    Given two strings, write a method to decide if  one is a permutation of the other.
    static boolean is_permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length();
        int cs[] = new int[256];
        int ct[] = new int[256];
        for (int i = 0; i < n; i++) {
            cs[s.charAt(i)]++;
            ct[t.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (ct[i] != cs[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {

        String x = "aabba";
        String y = "baabb";
        System.out.println(is_permutation(x, y));
    }
    /*
     * 
     * Aprendi , en la entrevista debo usar java.util.Arrays
     * new String(char[] c)
     * 
     */
}
