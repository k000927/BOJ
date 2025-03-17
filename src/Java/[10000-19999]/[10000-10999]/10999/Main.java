import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * 
 */

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	static int N;
	static int M;
	static int K;
	static long[] num;
	static long[] segmentTree;
	static long[] lazy;

	static void makeSegmentTree(int node, int left, int right) {
		if (left == right) {
			segmentTree[node] = num[left];
			return;
		}

		makeSegmentTree(node * 2, left, (left + right) / 2);
		makeSegmentTree(node * 2 + 1, (left + right) / 2 + 1, right);
		segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
	}

	static void updateLazy(int node, int start, int end) {
		if (lazy[node] != 0) {
			segmentTree[node] += (end - start + 1) * lazy[node];

			if (start != end) {
				lazy[node * 2] += lazy[node];
				lazy[node * 2 + 1] += lazy[node];
			}

			lazy[node] = 0;
		}
	}

	// left ~ right => 내가 탐색하고자 하는 구간, start~end => 현재 구간
	static long query(int node, int left, int right, int start, int end) {
		updateLazy(node, start, end);

		if (left > end || right < start)
			return 0L;

		if (left <= start && right >= end)
			return segmentTree[node];

		long leftQuery = query(node * 2, left, right, start, (start + end) / 2);
		long rightQuery = query(node * 2 + 1, left, right, (start + end) / 2 + 1, end);

		return leftQuery + rightQuery;
	}

	static void updateTree(long newValue, int node, int left, int right, int start, int end) {
		updateLazy(node, start, end);

		if (left > end || right < start)
			return;

		if (left <= start && right >= end) {
			segmentTree[node] += (end - start + 1) * newValue;

			if (start != end) {
				lazy[node * 2] += newValue;
				lazy[node * 2 + 1] += newValue;
			}

			return;
		}

		updateTree(newValue, node * 2, left, right, start, (start + end) / 2);
		updateTree(newValue, node * 2 + 1, left, right, (start + end) / 2 + 1, end);

		segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = nextInt();
		M = nextInt();
		K = nextInt();

		num = new long[N];
		segmentTree = new long[N * 4];
		lazy = new long[N * 4];

		for (int i = 0; i < N; i++) {
			num[i] = nextLong();
		}

		makeSegmentTree(1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			int a = nextInt();
			int b = nextInt() - 1;
			int c = nextInt() - 1;

			if (a == 1) {
				long d = nextLong();
				updateTree(d, 1, b, c, 0, N - 1);
			} else {
				System.out.println(query(1, b, c, 0, N - 1));
			}
		}
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}

	private static long nextLong() throws IOException {
		st.nextToken();
		return (long) st.nval;
	}
}
