import java.io.*;
import java.util.*;

public class Main {

    static boolean isPalindrome(String word) {
        boolean isPal = true;

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPal = false;
                break;
            }
        }

        return isPal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        boolean isAllSame = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(0) != word.charAt(i)) {
                isAllSame = false;
                break;
            }
        }

        if (isAllSame) {
            System.out.println(-1);
            System.exit(0);
        }

        if (isPalindrome(word)) {
            System.out.println(word.length() - 1);
        } else System.out.println(word.length());
    }
}