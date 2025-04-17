import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	static int n, m;
	static int[] compliment;
	static int[] superior;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder ans = new StringBuilder();

		n = nextInt();
		m = nextInt();

		compliment = new int[n + 1];
		superior = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			superior[i] = nextInt();
		}
		superior[1] = 0;

		for (int i = 0; i < m; i++) {
			compliment[nextInt()] += nextInt();
		}

		for (int i = 1; i <= n; i++) {
			compliment[i] += compliment[superior[i]];
			ans.append(compliment[i]).append(' ');
		}

		System.out.println(ans);
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
