import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static long[][] dp;

    static void init() {
        dp = new long[10000][5];

        dp[1][0] = 1L;
        for (int i = 2; i < 10000; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][4] + dp[i - 1][3];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][4];
            dp[i][2] = dp[i - 1][3];
            dp[i][3] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        init();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())+1][0]).append('\n');
        }
        System.out.print(sb);
    }
}