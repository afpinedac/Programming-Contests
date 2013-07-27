package UvaHunting.Mathematics.BigInteger;

import java.io.*;
import java.util.*;
import java.math.*;

public class X_Main_DP_FORM {

    public static void main(String[] args) throws Exception {
       //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        while (br.ready()) {
            String s[] = br.readLine().trim().split("[ ]+");
            int t = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);

            BigInteger numerador = BigInteger.valueOf(t);
            BigInteger denominador = BigInteger.valueOf(t);
           
            numerador = numerador.pow(a);
           
            numerador = numerador.subtract(BigInteger.ONE);
            denominador = denominador.pow(b);
            denominador = denominador.subtract(BigInteger.ONE);



            if (numerador.mod(denominador).equals(BigInteger.ZERO) && numerador.divide(denominador).toString().length() < 100) {
                System.out.println("(" + t + "^" + a + "-1)/(" + t + "^" + b + "-1) " + numerador.divide(denominador));
            } else {
                System.out.println("(" + t + "^" + a + "-1)/(" + t + "^" + b + "-1) is not an integer with less than 100 digits.");
            }
        }

    }
}
