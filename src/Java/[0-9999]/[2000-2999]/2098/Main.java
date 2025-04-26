import java.io.*;
import java.util.*;

public class Main {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static final int INF = 1000000000;
    static int[][] dp;
    static int[][] map;
    static int N;

    static int ans = Integer.MAX_VALUE;

    static void tsp(int cur, int visited) {
        if (visited == ((1 << N) - 1)) {
            if (map[cur][0] == 0) return;
            ans = Math.min(ans, dp[cur][visited] + map[cur][0]);
            return;
        }

        for (int i = 0; i < N; i++) {
            int next = (1 << i);

            if ((visited | next) == visited) continue;
            if (map[cur][i] == 0) continue;
            if (dp[cur][visited] + map[cur][i] < dp[i][visited | next]) {
                dp[i][visited | next] = dp[cur][visited] + map[cur][i];
                tsp(i, visited | next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = nextInt();
        map = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
            for (int j = 0; j < N; j++) {
                map[i][j] = nextInt();
            }
        }

        dp[0][1] = 0;
        tsp(0, 1);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

}