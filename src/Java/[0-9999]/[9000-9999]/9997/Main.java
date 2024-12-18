import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] words;
    static int ans = 0;
    static final int comp = (int) Math.pow(2, 26) - 1;

    static int wordToInt(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (word.contains(String.valueOf((char) (97 + i)))) sb.append(1);
            else sb.append(0);
        }
        return Integer.parseInt(sb.reverse().toString(), 2);
    }

    static void backTracking(int index, int curNum) {
        if (index == n) {
            if (curNum == comp) ans++;
        } else {
            backTracking(index + 1, curNum);
            backTracking(index + 1, curNum | words[index]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        words = new int[n];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words[i] = wordToInt(word);
        }

        backTracking(0, 0);
        System.out.println(ans);
    }
}