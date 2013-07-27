package UvaHunting.Introduction.SuperEasy;


import java.io.*;
import java.util.*;
import java.math.*;

public class Hajj_e_Akbar{
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
       
       
       int t = 1;
       while(true){
           String s = br.readLine().trim();
           
           if(s.equals("*")){
               break;
           }
           
           if(s.equalsIgnoreCase("Hajj")){
               System.out.println("Case "+ (t++) + ": Hajj-e-Akbar");
           }else{
               System.out.println("Case "+ (t++) + ": Hajj-e-Asghar"); 
           }
       }
      
    }
}

