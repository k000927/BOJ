import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp[i][j] = 나머지가 j인 i자리 수
        int[][] dp = new int[1516][3];
        int mod = 1000000007;

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i < 1516; i++) {
            dp[i][0] = (dp[i - 1][1] % mod + dp[i - 1][2] % mod) % mod;
            dp[i][1] = (dp[i - 1][2] % mod + dp[i - 1][0] % mod) % mod;
            dp[i][2] = (dp[i - 1][1] % mod + dp[i - 1][0] % mod) % mod;
        }

        System.out.println(dp[n - 1][1]);
    }
}