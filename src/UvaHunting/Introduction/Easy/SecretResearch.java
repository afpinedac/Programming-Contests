package UvaHunting.Introduction.Easy;

import java.io.*;

public class SecretResearch {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String line = br.readLine();
            if (line.equals("1") || line.equals("4") || line.equals("78")) {
                System.out.println("+");
            } else if (line.endsWith("35")) {
                System.out.println("-");
            } else if (line.startsWith("9") && line.endsWith("4")) {
                System.out.println("*");
            } else {
                System.out.println("?");
            }
        }

    }
}