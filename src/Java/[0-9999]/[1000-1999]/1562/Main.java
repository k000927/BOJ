import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		final int MOD = 1000000000;

		// dp[I][J]K] => I길이의 계단 수, 끝자리는 J, 사용한 숫자는 K(비트)
		int[][][] dp = new int[101][10][1024];

		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int i = 1; i < 100; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 1024; k++) {
					if (dp[i][j][k] == 0)
						continue;
					if (j != 0) {
						dp[i + 1][j - 1][k | (1 << (j - 1))] += dp[i][j][k] % MOD;
						dp[i + 1][j - 1][k | (1 << (j - 1))] %= MOD;
					}
					if (j != 9) {
						dp[i + 1][j + 1][k | (1 << (j + 1))] += dp[i][j][k] % MOD;
						dp[i + 1][j + 1][k | (1 << (j + 1))] %= MOD;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += dp[N][i][1023];
			ans %= MOD;
		}

		System.out.println(ans);
	}
}
