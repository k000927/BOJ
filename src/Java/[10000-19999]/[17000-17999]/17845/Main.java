import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * 배낭 문제
 */

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = nextInt();
		int K = nextInt();

		int[] dp = new int[N + 1];

		int i, t;
		for (int k = 0; k < K; k++) {
			i = nextInt();
			t = nextInt();
			for (int n = N; n >= t; n--) {
				dp[n] = Math.max(dp[n], dp[n - t] + i);
			}
		}

		System.out.println(dp[N]);
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
