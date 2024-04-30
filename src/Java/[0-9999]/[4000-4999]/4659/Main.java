import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password;
        List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
        while (!(password = br.readLine()).equals("end")) {
            Boolean flag = true;
            password = password;
            int num_of_vowel = 0;
            int con_vowel = 0;
            int con_cons = 0;
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (vowel.contains(c)) {
                    num_of_vowel++;
                    con_vowel++;
                    con_cons = 0;
                } else {
                    con_cons++;
                    con_vowel = 0;
                }
                if (con_vowel == 3 || con_cons == 3) {
                    flag = false;
                }
                if (i == 0) continue;
                if (c == password.charAt(i - 1) && (c != 'o' && c != 'e')) {
                    flag = false;
                }
            }
            if (num_of_vowel == 0) flag = false;
            if (flag) System.out.printf("<%s> is acceptable.\n", password);
            else System.out.printf("<%s> is not acceptable.\n", password);
        }
    }
}