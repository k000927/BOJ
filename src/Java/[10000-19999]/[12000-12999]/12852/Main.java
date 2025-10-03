import java.io.*;
import java.util.*;

public class Main {
    static int X;
    static int[] dp;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        dp = new int[1000001];
        parent = new int[1000001];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i < 1000000; i++) {
            if (i * 3 <= 1000000 && dp[i * 3] > dp[i] + 1) {
                dp[i * 3] = dp[i] + 1;
                parent[i * 3] = i;
            }

            if (i * 2 <= 1000000 && dp[i * 2] > dp[i] + 1) {
                dp[i * 2] = dp[i] + 1;
                parent[i * 2] = i;
            }

            if (dp[i + 1] > dp[i] + 1) {
                dp[i + 1] = dp[i] + 1;
                parent[i + 1] = i;
            }
        }

        int ans = -1;
        StringBuilder history = new StringBuilder();

        while (X != 0) {
            history.append(X).append(' ');
            ans++;
            X = parent[X];
        }

        System.out.println(ans);
        System.out.println(history);
    }
}