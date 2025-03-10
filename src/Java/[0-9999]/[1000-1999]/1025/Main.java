import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static char[][] num;
	static int maxSquared = -1;
	static HashSet<Integer> squareSet;

	static boolean isSquared(String n) {
		int intN = Integer.parseInt(n);

		if (squareSet.contains(intN))
			return true;
		else
			return false;
	}

	static void getSquared(int i, int j, int iHop, int jHop) {
		StringBuilder numString = new StringBuilder();

		for (; i < n && i >= 0 && j < m && j >= 0; j += jHop, i += iHop) {
			numString.append(num[i][j]);
			if (isSquared(numString.toString()))
				maxSquared = Math.max(maxSquared, Integer.parseInt(numString.toString()));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		num = new char[n][m];
		squareSet = new HashSet<>();

		for (int i = 0; i * i < 999999999; i++) {
			squareSet.add(i * i);
		}

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				num[i][j] = line.charAt(j);
			}
		}

		if (n == 1 && m == 1) {
			if (isSquared(String.valueOf(num[0][0])))
				maxSquared = num[0][0] - '0';

			System.out.println(maxSquared);
			System.exit(0);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int iHop = -1 * n + 1; iHop < n; iHop++) {
					for (int jHop = -1 * m + 1; jHop < m; jHop++) {
						if (iHop == 0 && jHop == 0)
							continue;
						getSquared(i, j, iHop, jHop);
					}
				}
			}
		}

		System.out.println(maxSquared);

	}

}
