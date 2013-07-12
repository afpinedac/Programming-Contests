/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.Algorithms.Regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author AndresPineda
 */
public class X_DetectetHTMLLinks {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));


        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(br.readLine());
        }


        Pattern links = Pattern.compile("href=\"(/|#|h)*[a-z_\\-]*(:|//|/)*");
        Matcher m = links.matcher(sb.toString());
        while (m.find()) {
            System.out.println(m.group());
        }








    }
}
