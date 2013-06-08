//package programming;

import java.io.*;
import java.util.*;

public class HomeworkChecker {

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = 0;
        while (br.ready()) {
            String L = br.readLine();
            String N[] = L.split("=");
            if (!N[1].equals("?")) {
                for (int i = 0; i < N[0].length(); i++) {
                    char c = N[0].charAt(i);
                    if (!Character.isDigit(c)) {
                        int n1 = Integer.parseInt(N[0].substring(0, i));
                        int n2 = Integer.parseInt(N[0].substring(i + 1, N[0].length()));
                        if (c == '-') {
                            if (n1 - n2 == Integer.parseInt(N[1])) {
                                g++;
                            }
                        } else {
                            if (n1 + n2 == Integer.parseInt(N[1])) {
                                g++;
                            }
                        }
                    }
                }
            }

        }
        System.out.println(g);
    }
}
