import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] kids = new int[n];
        for (int i = 0; i < n; i++) {
            kids[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (kids[i] > kids[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) dp[i] = 1;
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(n - ans);
    }
}