import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String str;
	static int N;
	static boolean[][] palindrome;
	static int[] dp;

	static void doPalindrome() {
		palindrome = new boolean[N][N];
		for (int i = 0; i < N - 1; i++) {
			palindrome[i][i] = true;
			if (str.charAt(i) == str.charAt(i + 1))
				palindrome[i][i + 1] = true;
		}
		palindrome[N - 1][N - 1] = true;

		for (int l = 3; l <= N; l++) {
			for (int s = 0; s + l <= N; s++) {
				if (str.charAt(s) == str.charAt(s + l - 1) && palindrome[s + 1][s + l - 2])
					palindrome[s][s + l - 1] = true;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = str.length();

		doPalindrome();

		dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (palindrome[i][j])
					dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
			}
		}

		System.out.println(dp[N]);
	}
}
