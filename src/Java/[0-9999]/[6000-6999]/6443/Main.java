import java.io.*;
import java.util.*;

public class Main {
    static int[] alphacnt;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        String input;
        alphacnt = new int[26];

        for (int i = 0; i < N; ++i) {
            input = br.readLine().toString();

            for (int j = 0; j < input.length(); j++) {
                alphacnt[input.charAt(j) - 'a']++;
            }

            dfs(input.length(), sb);

            for (int j = 0; j < 26; j++) {
                alphacnt[j] = 0;
            }
        }

    }

    public static void dfs(int maxlen, StringBuilder sb) {

        if (maxlen == sb.length()) {
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alphacnt[i] > 0) {
                alphacnt[i]--;
                sb.append((char) (i + 'a'));
                dfs(maxlen, sb);
                alphacnt[i]++;
                sb.setLength(sb.length() - 1);
            }
        }
    }
}