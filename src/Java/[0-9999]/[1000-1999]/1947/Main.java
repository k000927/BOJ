import java.io.*;

public class Main {
    static final int MOD = 1000000000;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[] dp = new long[Math.max(3, N + 1)];
        dp[2] = 1L;
        for (int i = 3; i <= N; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % MOD;
        }

        System.out.println(dp[N]);
    }
}