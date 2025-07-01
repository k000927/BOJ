import java.io.*;
import java.util.*;

public class Main {
    static int T;

    static int removeLeft(String str) {
        boolean flag = false;
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                if (!flag) {
                    if (str.charAt(i + 1) == str.charAt(j)) {
                        i += 2;
                        j--;
                        flag = true;
                    } else return 2;
                } else return 2;
            }
        }

        if (flag) return 1;
        else return 0;
    }

    static int removeRight(String str) {
        boolean flag = false;
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                if (!flag) {
                    if (str.charAt(i) == str.charAt(j - 1)) {
                        i++;
                        j -= 2;
                        flag = true;
                    } else return 2;
                } else return 2;
            }
        }

        if (flag) return 1;
        else return 0;
    }

    static int isPalindrome(String str) {
        int left = removeLeft(str);
        int right = removeRight(str);

        if (left == 0 || right == 0) return 0;
        else if (left == 1 || right == 1) return 1;
        else return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            sb.append(isPalindrome(br.readLine())).append('\n');
        }
        System.out.print(sb);
    }
}