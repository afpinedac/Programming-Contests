package programming;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Parity {
    
   

    public static void main(String args[]) throws Exception {
     //   BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      
      
      while(true){
          int N=Integer.parseInt(br.readLine());
          if(N==0) break;
          System.out.println("The parity of "+Integer.toBinaryString(N) +" is "+Integer.bitCount(N) +" (mod 2).");
      }
      
    }
    
}
