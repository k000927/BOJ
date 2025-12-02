import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] price;
    static int[][] dp;

    // dp[i][j] => 그림이 i원일 때 소유한 사람 j, 값은 마지막으로 소유한 사람
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        price = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                price[i][j] = input.charAt(j) - '0';
            }
        }

        dp = new int[10][1 << N];
        int ans = 1;
        dp[0][1] = 1;
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < 1 << N; j++) {
                if (dp[i][j] == 0)
                    continue;
                for (int prev = 0; prev < N; prev++) {
                    if ((j & (1 << prev)) == 0 || ((dp[i][j] & (1 << prev)) == 0)) {
                        continue;
                    }
                    for (int next = 1; next < N; next++) {
                        if (prev == next || ((j & (1 << next)) != 0))
                            continue;

                        int nextPrice = price[prev][next];
                        if (nextPrice < i)
                            continue;
                        dp[nextPrice][j | (1 << next)] |= (1 << next);
                        ans = Math.max(ans, Integer.bitCount(j | (1 << next)));
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
