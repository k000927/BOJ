import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int loop = 0; loop < T; loop++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 1)
				System.out.println(0);
			else {
				StringBuilder ans = new StringBuilder("1");
				for (int i = 0; i < N - 2; i++) {
					ans.append("2");
				}
				ans.append("1");
				System.out.println(ans);
			}
		}
	}
}
