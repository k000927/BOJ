import java.io.*;
import java.util.*;

public class Main {
    static int N, G, all, J, C;
    static double[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        G = all = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            all += Integer.parseInt(st.nextToken());
        }

        J = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        // dp[i][j] -> i주차 j번 당첨될 확률
        dp = new double[C + 1][C + 1];
        dp[0][0] = 1;
        for (int i = 0; i < C; i++) {

            for (int j = 0; j <= i; j++) {
                dp[i + 1][j + 1] += dp[i][j] * (double) (G + J * j) / (all + J * i);
                dp[i + 1][j] += dp[i][j] * (1 - (double) (G + J * j) / (all + J * i));
            }

        }


        double ans = 0;
        for (int i = 0; i <= C; i++) {
            ans += dp[C][i] * (G + J * i);
        }

        System.out.println(ans);
    }
}