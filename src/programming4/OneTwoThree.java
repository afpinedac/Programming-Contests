//package programming;

import java.io.*;
import java.util.*;

public class OneTwoThree {

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        
        int N=Integer.parseInt(br.readLine());
        while(N-->0){
            String line=br.readLine();
            if(line.length()==5){
                System.out.println("3");
            }else if(line.charAt(0)=='t' || line.charAt(2)=='o'){
                System.out.println("2");
            }else{
                System.out.println("1");
            }
            
        }

    }
}
