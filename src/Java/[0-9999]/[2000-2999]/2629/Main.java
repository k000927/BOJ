import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] pendulum;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pendulum = new int[N];
        dp = new boolean[N][500 * 30 * 2 + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pendulum[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][pendulum[0] + 15000] = true;
        dp[0][-pendulum[0] + 15000] = true;
        dp[0][15000] = true;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 500 * 30 * 2 + 1; j++) {
                if (!dp[i - 1][j]) continue;

                dp[i][j] = true;
                dp[i][j + pendulum[i]] = true;
                dp[i][j - pendulum[i]] = true;
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i++) {
            try {
                ans.append(dp[N - 1][Integer.parseInt(st.nextToken()) + 15000] ? 'Y' : 'N').append(' ');
            } catch (ArrayIndexOutOfBoundsException e) {
                ans.append('N').append(' ');
            }
        }
        System.out.println(ans);
    }
}
