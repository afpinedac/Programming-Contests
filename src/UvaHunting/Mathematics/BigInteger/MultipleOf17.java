package programming;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class MultipleOf17 {

    

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            BigInteger bi=new BigInteger(br.readLine());
            if(bi.equals(BigInteger.ZERO))break;
            if(bi.remainder(BigInteger.valueOf(17))==BigInteger.ZERO){
                System.out.println("1");
            }else{
                 System.out.println("0");
            }
        }
    
    }
}
