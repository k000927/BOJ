import java.io.*;
import java.util.*;

import static java.lang.Math.min;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 1000;

        int[][] space = new int[n][m];
        int[][] dp1 = new int[n][m];    // 왼쪽 아래
        int[][] dp2 = new int[n][m];    // 아래
        int[][] dp3 = new int[n][m];    // 오른쪽 아래

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            dp1[0][i] = space[0][i];
            dp2[0][i] = space[0][i];
            dp3[0][i] = space[0][i];
        }
        for (int i = 0; i < n - 1; i++) {
            dp1[i + 1][0] = space[i + 1][0] + min(dp2[i][1], dp3[i][1]);
            dp2[i + 1][0] = space[i + 1][0] + dp1[i][0];
            dp3[i + 1][0] = max;
            for (int j = 1; j < m - 1; j++) {
                dp1[i + 1][j] = space[i + 1][j] + min(dp2[i][j + 1], dp3[i][j + 1]);
                dp2[i + 1][j] = space[i + 1][j] + min(dp1[i][j], dp3[i][j]);
                dp3[i + 1][j] = space[i + 1][j] + min(dp1[i][j - 1], dp2[i][j - 1]);
            }
            dp1[i + 1][m - 1] = max;
            dp2[i + 1][m - 1] = space[i + 1][m - 1] + dp3[i][m - 1];
            dp3[i + 1][m - 1] = space[i + 1][m - 1] + min(dp1[i][m - 2], dp2[i][m - 2]);
        }

        int ans = max;
        for (int i = 0; i < m; i++) {
            ans = min(ans, dp1[n - 1][i]);
            ans = min(ans, dp2[n - 1][i]);
            ans = min(ans, dp3[n - 1][i]);
        }
        System.out.println(ans);
    }
}