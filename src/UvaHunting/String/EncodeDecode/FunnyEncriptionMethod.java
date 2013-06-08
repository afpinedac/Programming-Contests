package programming;

import java.io.*;
import java.util.*;

public class FunnyEncriptionMethod {

    public static void main(String args[]) throws Exception {
       // BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        while(N-->0){
            int X1=Integer.parseInt(br.readLine());                       
            int X2=Integer.parseInt(""+X1, 16);           
             System.out.println(Integer.bitCount(X1) + " " + Integer.bitCount(X2) );
        }
    }
}
