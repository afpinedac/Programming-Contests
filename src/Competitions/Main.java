
import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));



        while (br.ready()) {
            int n = Integer.parseInt(br.readLine().trim());
            String pattern = br.readLine().trim();
            String s = br.readLine().trim();
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(s);

            boolean found = false;

            int i = 0;
            while (m.find(i)) {
                found = true;
                System.out.println(m.start());
                i = m.start() + 1;
            }
            if(!found){
                System.out.println("");
            }
        }

    }
}
