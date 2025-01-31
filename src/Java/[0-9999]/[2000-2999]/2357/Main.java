import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static NumPair[] pairTree;
	static int[] num;
	static StringBuilder ans = new StringBuilder();

	static class NumPair {
		long min;
		int max;

		NumPair() {

		}

		NumPair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	static void setTree(int node, int start, int end) {
		if (start == end) {
			pairTree[node].min = num[start];
			pairTree[node].max = num[start];
		} else {
			setTree(node * 2, start, (start + end) / 2);
			setTree(node * 2 + 1, (start + end) / 2 + 1, end);
			pairTree[node].min = Math.min(pairTree[node * 2].min, pairTree[node * 2 + 1].min);
			pairTree[node].max = Math.max(pairTree[node * 2].max, pairTree[node * 2 + 1].max);
		}
	}

	static NumPair getTree(int node, int left, int right, int start, int end) {
		if (right < start || left > end)
			return new NumPair(Integer.MAX_VALUE, Integer.MIN_VALUE);
		if (left <= start && end <= right) {
			return pairTree[node];
		}

		NumPair lPair = getTree(node * 2, left, right, start, (start + end) / 2);
		NumPair rPair = getTree(node * 2 + 1, left, right, (start + end) / 2 + 1, end);

		NumPair pair = new NumPair();
		pair.min = Math.min(lPair.min, rPair.min);
		pair.max = Math.max(lPair.max, rPair.max);

		return pair;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		pairTree = new NumPair[n * 4];
		for (int i = 0; i < n * 4; i++) {
			pairTree[i] = new NumPair();
		}
		num = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		setTree(1, 1, n);

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			NumPair pair = getTree(1, a, b, 1, n);

			ans.append(pair.min).append(" ").append(pair.max).append("\n");
		}

		System.out.println(ans);
	}
}
