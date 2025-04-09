import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 각 간선의 길이가 1000 이하인 경로를 선택해 집부터 페스티벌까지 이동할 수 있다면 성공
 */

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	static List<Integer>[] adj;

	static int[] posX;
	static int[] posY;
	static boolean[] visited;

	static int n;

	static String bfs() {
		queue.clear();
		queue.add(0);
		visited[0] = true;

		int cur;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			for (int next : adj[cur]) {
				if (visited[next])
					continue;

				if (next == n + 1)
					return "happy";

				visited[next] = true;
				queue.add(next);
			}
		}

		return "sad";
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder ans = new StringBuilder();

		posX = new int[102];
		posY = new int[102];
		visited = new boolean[102];
		adj = new ArrayList[102];
		for (int i = 0; i < 102; i++) {
			adj[i] = new ArrayList<>();
		}
		int t = nextInt();

		while (t-- > 0) {
			n = nextInt();
			Arrays.fill(visited, false);
			for (int i = 0; i <= n + 1; i++) {
				adj[i].clear();
				posX[i] = nextInt();
				posY[i] = nextInt();

				for (int j = 0; j < i; j++) {
					if (Math.abs(posX[i] - posX[j]) + Math.abs(posY[i] - posY[j]) <= 1000) {
						adj[j].add(i);
						adj[i].add(j);
					}

				}
			}

			ans.append(bfs()).append("\n");
		}

		System.out.println(ans);
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}

	static MyQueue queue = new MyQueue();

	static class MyQueue {
		int[] xQueue;
		int head, tail;

		MyQueue() {
			xQueue = new int[102];
			head = tail = 0;
		}

		public boolean isEmpty() {
			return head == tail;
		}

		public int poll() {
			return xQueue[head++];
		}

		public void add(int x) {
			xQueue[tail++] = x;
		}

		public void clear() {
			head = tail = 0;
		}
	}
}
