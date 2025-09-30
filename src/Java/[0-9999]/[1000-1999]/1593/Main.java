import java.io.*;
import java.util.*;

public class Main {
    static int g, s;
    static String W, S;

    static int[] cur, target;

    static boolean judge() {
        for (int i = 0; i < 52; i++) {
            if (cur[i] != target[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        g = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        W = br.readLine();
        S = br.readLine();

        cur = new int[52];
        target = new int[52];
        for (int i = 0; i < g; i++) {
            if ('a' <= W.charAt(i) && W.charAt(i) <= 'z')
                target[W.charAt(i) - 'a']++;
            else {
                target[W.charAt(i) - 'A' + 26]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < g - 1; i++) {
            if ('a' <= S.charAt(i) && S.charAt(i) <= 'z')
                cur[S.charAt(i) - 'a']++;
            else {
                cur[S.charAt(i) - 'A' + 26]++;

            }
        }

        for (int i = g - 1; i < s; i++) {
            if ('a' <= S.charAt(i) && S.charAt(i) <= 'z')
                cur[S.charAt(i) - 'a']++;
            else {
                cur[S.charAt(i) - 'A' + 26]++;
            }

            if (judge()) ans++;

            if ('a' <= S.charAt(i - g + 1) && S.charAt(i - g + 1) <= 'z')
                cur[S.charAt(i - g + 1) - 'a']--;
            else {
                cur[S.charAt(i - g + 1) - 'A' + 26]--;
            }
        }

        System.out.println(ans);
    }
}