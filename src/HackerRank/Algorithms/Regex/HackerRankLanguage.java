package HackerRank.Algorithms.Regex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankLanguage {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            Pattern p = Pattern.compile("^C$|^CPP$|^JAVA$|^PYTHON$|^PERL$|^PHP$|^RUBY$|^CSHARP$|^HASKELL$|^CLOJURE$|^BASH$|^SCALA$|^ERLANG$|^CLISP$|^LUA$|^BRAINFUCK$|^JAVASCRIPT$|^GO$|^D$|^OCAML$|^R$|^PASCAL$|^SBCL$|^DART$|^GROOVY$|^OBJECTIVEC$");
            String line[] = br.readLine().trim().split("[ ]+");
            Matcher m = p.matcher(line[1]);
            if (m.find()) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
            }

        }

    }
}
