import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		if (a + b > n + 1) {
			System.out.println(-1);
			System.exit(0);
		}

		int[] building = new int[n];
		Arrays.fill(building, 1);

		StringBuilder ans = new StringBuilder();
		int i = n;
		if (a == 1) {
			building[0] = b;

			for (int x = 1; x <= b - 1; x++) {
				i--;
				building[i] = x;
			}
		} else if (a > b) {
			for (int x = 1; x <= b - 1; x++) {
				i--;
				building[i] = x;
			}

			for (int x = a; x >= 2; x--) {
				i--;
				building[i] = x;
			}

		} else {

			for (int x = 1; x <= b; x++) {
				i--;
				building[i] = x;
			}

			for (int x = a - 1; x >= 2; x--) {
				i--;
				building[i] = x;
			}
		}

		for (int idx = 0; idx < n; idx++) {
			ans.append(building[idx]).append(" ");
		}
		System.out.println(ans);
	}
}
