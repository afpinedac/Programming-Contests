package UvaHunting.String.InputParsing;

import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.Pattern;

public class X_Pascal {

    static String delete_right(String s) {
        int c = -1;
        if (s.trim().equals("")) {
            return " ";
        }
        while (s.charAt(++c) == ' ');
        return s.substring(c, s.length());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        String s;

        StringBuilder sb = new StringBuilder();

        while ((s = br.readLine()) != null) {
            sb = new StringBuilder();
            if (s.equals("*")) {
                break;
            }
            s = delete_right(s);
            //    System.out.println(s);
            sb.append(s).append(" is ");

            boolean decimal = false;
            boolean exponent = false;
            boolean valid = true;


            char c = s.charAt(0);
            // System.out.println(" 0 = " + c);
            if (Character.isDigit(c) || c == '+' || c == '-' || c == 'e' || c == 'E') {
                //  System.out.println("-->" + c);
                if (Character.isDigit(c) || c == '+' || c == '-') {
                    //   System.out.println("pasa");
                    int start = Character.isDigit(c) ? 0 : 1;
                    boolean entro = false;
                    while (start < s.length() && Character.isDigit(s.charAt(start))) {
                        entro = true;
                        start++;
                    }

                    if (start == s.length()) {  // llego al final
                        entro = false;
                    }

                    if (!entro) {
                        //  System.out.println("no entro");
                        valid = false;
                    } else {
                        c = s.charAt(start);
                        // System.out.println("c = " + c);
                        if (c == '.' || c == 'e' || c == 'E') {
                            if (c == '.') {     // tiene decimal
                                //  System.out.println("encontro punto  ---------");
                                decimal = true;
                                start++;

                                if (start < s.length()) {
                                    c = s.charAt(start);
                                    entro = true;
                                    while (start < s.length() && Character.isDigit(s.charAt(start))) {
                                        entro = true;
                                        start++;
                                    }

                                    if (!entro) {
                                        valid = false;
                                    } else {
                                        if (start != s.length()) {
                                            c = s.charAt(start);
                                            if (c == 'e' || c == 'E') {
                                                exponent = true;
                                                //  decimal = false;
                                                start++;
                                                if (start < s.length()) {
                                                    c = s.charAt(start);
                                                    if (c == '+' || c == '-' || Character.isDigit(c)) {  // tiene  simbolo el exponente
                                                        if (Character.isDigit(c)) {
                                                            boolean number = true;
                                                            for (int i = start; i < s.length(); i++) { // termine en numeross
                                                                if (!Character.isDigit(s.charAt(i))) {
                                                                    number = false;
                                                                    break;
                                                                }
                                                            }
                                                            valid = number;

                                                        } else {
                                                            start++;
                                                            if (start < s.length()) {
                                                                boolean number = true;
                                                                for (int i = start; i < s.length(); i++) { // termine en numeross
                                                                    if (!Character.isDigit(s.charAt(i))) {
                                                                        number = false;
                                                                        break;
                                                                    }
                                                                }
                                                                valid = number;
                                                            } else {
                                                                // System.out.println("x1");
                                                                valid = false;
                                                            }

                                                        }


                                                    } else {
                                                        //  System.out.println("+x3");
                                                        valid = false;
                                                    }
                                                } else { // termino en e
                                                    // System.out.println("+x2");
                                                    valid = false;
                                                }
                                            } else {
                                                // System.out.println("+x1");
                                                valid = false;
                                            }
                                        }
                                    }


                                } else {
                                    // System.out.println("termina en un punto");
                                    valid = false;
                                }
                            } else { // exponente inmediatamente
                                //   System.out.println("no tiene decimal y es exponente");
                                exponent = true;
                                decimal = false;
                                start++;
                                if (start < s.length()) {
                                    c = s.charAt(start);
                                    if (c == '+' || c == '-' || Character.isDigit(c)) {  // tiene  simbolo el exponente
                                        if (Character.isDigit(c)) {
                                            boolean number = true;
                                            for (int i = start; i < s.length(); i++) { // termine en numeross
                                                if (!Character.isDigit(s.charAt(i))) {
                                                    number = false;
                                                    break;
                                                }
                                            }
                                            valid = number;

                                        } else {
                                            start++;
                                            if (start < s.length()) {
                                                boolean number = true;
                                                for (int i = start; i < s.length(); i++) { // termine en numeross
                                                    if (!Character.isDigit(s.charAt(i))) {
                                                        number = false;
                                                        break;
                                                    }
                                                }
                                                valid = number;
                                            } else {
                                                // System.out.println("x1");
                                                valid = false;
                                            }

                                        }


                                    } else {
                                        // System.out.println("x2");
                                        valid = false;
                                    }
                                } else { // termino en e
                                    // System.out.println("x3");
                                    valid = false;
                                }
                            }
                        } else {
                            valid = false;
                        }
                    }
                } else {

                    exponent = true;
                    decimal = false;
                    int start = 0;
                    start++;
                    if (start < s.length()) {
                        c = s.charAt(start);
                        if (c == '+' || c == '-' || Character.isDigit(c)) {  // tiene  simbolo el exponente
                            if (Character.isDigit(c)) {
                                boolean number = true;
                                for (int i = start; i < s.length(); i++) { // termine en numeross
                                    if (!Character.isDigit(s.charAt(i))) {
                                        number = false;
                                        break;
                                    }
                                }
                                valid = number;

                            } else {
                                start++;
                                if (start < s.length()) {
                                    boolean number = true;
                                    for (int i = start; i < s.length(); i++) { // termine en numeross
                                        if (!Character.isDigit(s.charAt(i))) {
                                            number = false;
                                            break;
                                        }
                                    }
                                    valid = number;
                                } else {
                                    // System.out.println("x1");
                                    valid = false;
                                }

                            }


                        } else {
                            // System.out.println("x2");
                            valid = false;
                        }
                    } else { // termino en e
                        // System.out.println("x3");
                        valid = false;
                    }
                }
            } else {
                //  System.out.println("no tiene simbolo ni arranca con numero");
                valid = false;
            }

            // ojo hay que cambiar las opciones

            if (!exponent && !decimal) {
                valid = false;
            }



            sb.append(valid ? "legal." : "illegal.");
            System.out.println(sb.toString());

        }

        // System.out.println(sb.toString().trim());
    }
}
