import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * dp[i][j] -> i번째 동전을 썼을 때, j 원을 만드는 방법
 * dp[i][j] = dp[i-1][j] + dp[i-1][j-coin[i]] + 1
 * 
 * dp[i-1][j] => i번째 동전을 안 쓰고 j원 을 만든 경우
 * dp[i-1][j] => i번째 동전을 쓰고 j원을 만든 경우
 */

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder ans = new StringBuilder();
		int T, N, M;
		int[] coin = new int[21];
		int[][] dp = new int[21][10001];

		T = nextInt();
		while (T-- > 0) {
			N = nextInt();

			for (int i = 1; i <= N; i++) {
				coin[i] = nextInt();
			}

			M = nextInt();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j < coin[i]; j++)
					dp[i][j] = dp[i - 1][j];

				dp[i][coin[i]] = dp[i - 1][coin[i]] + 1;

				for (int j = coin[i] + 1; j <= M; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i]];
				}
			}

			ans.append(dp[N][M]).append("\n");
		}

		System.out.println(ans);
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
