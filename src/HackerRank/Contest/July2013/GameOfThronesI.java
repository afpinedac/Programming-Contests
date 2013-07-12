package HackerRank.Contest.July2013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GameOfThronesI {

    static int N;
    static boolean palindrome;
    static boolean used[];
    static char word[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int n = line.length();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);
            hm.put(c, hm.containsKey(c) ? hm.get(c) + 1 : 1);
        }


        boolean palindrome = true;
        int odds = 0;
        if (n % 2 == 0) {
            for (Map.Entry<Character, Integer> data : hm.entrySet()) {
                if (data.getValue() % 2 != 0) {
                    palindrome = false;
                    break;
                }
            }
        } else {
            for (Map.Entry<Character, Integer> data : hm.entrySet()) {
                // System.out.println(data.getValue());
                if (data.getValue() % 2 != 0) {
                    odds++;
                }
                if (odds > 1) {
                    palindrome = false;
                    break;
                }
            }
            //   System.out.println(odds);

        }

        System.out.println(palindrome ? "YES" : "NO");






    }
}
