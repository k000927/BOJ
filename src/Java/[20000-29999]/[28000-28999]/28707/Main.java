import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	static int N;
	static int M;
	static int[][] op;
	static char[] target;

	static Queue<Edge> pq = new PriorityQueue<>();
	static HashMap<String, Integer> visited = new HashMap<>();

	static class Edge implements Comparable<Edge> {
		char[] c;
		int weight;

		Edge(char[] c, int weight) {
			this.c = c;
			this.weight = weight;
		};

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}

	static int dijkstra(char[] A) {
		pq.add(new Edge(A, 0));

		Edge e;
		char temp;
		int nextWeight;
		String next;
		while (!pq.isEmpty()) {
			e = pq.poll();

			if (arrCompare(e.c, target))
				return e.weight;

			for (int i = 0; i < M; i++) {
				char[] c = e.c.clone();

				temp = c[op[i][0]];
				c[op[i][0]] = c[op[i][1]];
				c[op[i][1]] = temp;
				nextWeight = e.weight + op[i][2];

				next = charArrToString(c);

				if (visited.containsKey(next)) {
					if (visited.get(next) <= nextWeight)
						continue;
				}

				visited.put(next, nextWeight);
				pq.add(new Edge(c, nextWeight));
			}
		}

		return -1;
	}

	static boolean arrCompare(char[] a, char[] b) {
		for (int i = 0; i < N; i++) {
			if (a[i] != b[i])
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = nextInt();
		char[] A = new char[N];
		target = new char[N];

		for (int i = 0; i < N; i++) {
			A[i] = (char) ((nextInt() - 1) + '0');
			target[i] = A[i];
		}

		Arrays.sort(target);

		M = nextInt();
		op = new int[M][3];
		for (int i = 0; i < M; i++) {
			op[i][0] = nextInt() - 1;
			op[i][1] = nextInt() - 1;
			op[i][2] = nextInt();
		}

		System.out.println(dijkstra(A));

	}

	public static String charArrToString(char[] c) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(c[i]);
		}

		return sb.toString();
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
