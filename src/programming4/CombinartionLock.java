package programming;

import java.io.*;
import java.util.*;

public class CombinartionLock {

    public static int getAngle(int pos) {
        return pos * 9;
    }

    public static int angle(int pos1, int pos2, boolean cw) {
        cw = !cw;
        if (cw) {
            if (pos1 < pos2) {
                return getAngle(pos2) - getAngle(pos1);
            } else if (pos1 > pos2) {
                return 360 - (getAngle(pos1) - getAngle(pos2));
            }
        } else {
            if (pos1 > pos2) {
                return (getAngle(pos1) - getAngle(pos2));
            } else if (pos1 < pos2) {
                return 360 - (getAngle(pos2) - getAngle(pos1));
            }
        }

        return 0;
    }

    public static void main(String args[]) throws Exception {


        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while (br.ready()) {
            String line[] = br.readLine().trim().split("[ ]+");

            int posini = Integer.parseInt(line[0]);
            int pos1 = Integer.parseInt(line[1]);
            int pos2 = Integer.parseInt(line[2]);
            int pos3 = Integer.parseInt(line[3]);

            if (posini == 0 && pos1 == 0 & pos2 == 0 && pos3 == 0) {
                break;
            }


            //   System.out.println(posini + " " + pos1 + " " + pos2  + " " + pos3);
            System.out.println(720 + angle(posini, pos1, true) + 360 + angle(pos1, pos2, false) + angle(pos2, pos3, true));

        }
    }
}
