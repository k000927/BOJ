import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] house;
    static int[][][] dp;
    static int ans = Integer.MAX_VALUE;

    // 0 -> R로 시작
    // 1 -> G로 시작
    // 2 -> B로 시작

    static void getDP(int color) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[color][i], 1000 * 1000);
        }

        dp[color][0][color] = house[0][color];

        for (int i = 1; i < n; i++) {
            dp[color][i][0] = Math.min(dp[color][i - 1][1], dp[color][i - 1][2]) + house[i][0];
            dp[color][i][1] = Math.min(dp[color][i - 1][0], dp[color][i - 1][2]) + house[i][1];
            dp[color][i][2] = Math.min(dp[color][i - 1][1], dp[color][i - 1][0]) + house[i][2];
        }

        dp[color][n - 1][color] = Integer.MAX_VALUE;

        ans = Math.min(ans, Math.min(dp[color][n - 1][0], Math.min(dp[color][n - 1][1], dp[color][n - 1][2])));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        house = new int[n][3];
        dp = new int[3][n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        getDP(0);
        getDP(1);
        getDP(2);

        System.out.println(ans);
    }
}