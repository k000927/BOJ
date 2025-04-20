import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	static int N;
	static Village[] villageTree;
	// 0 -> 해당 마을이 우수 마을이 아닐 때 최댓값
	// 1 -> 해당 마을이 우수 마을일 때 최댓값
	static int[][] dp;
	static boolean[] visited;

	static class Village {
		int villageIndex;
		int population;
		Queue<Integer> adj;

		Village(int villageIndex, int population) {
			this.villageIndex = villageIndex;
			this.population = population;
			adj = new ArrayDeque<>();
		}

		void add(int vIndex) {
			adj.add(vIndex);
		}
	}

	static void treeDP(int parent, int vIndex) {
		// 단말 노드의 경우
		if (villageTree[vIndex].adj.size() == 1 && parent != 0) {
			dp[vIndex][0] = 0;
			dp[vIndex][1] = villageTree[vIndex].population;
			return;
		}

		Village curV = villageTree[vIndex];
		// 현재 마을이 우수 마을일 경우 -> 인접한 마을은 전부 우수 마을이 아니어야 한다.
		// 현재 마을이 우수 마을이 아닐 경우 -> 인접한 마을의 dp 최댓값 but 전부 우수 마을이 아닌건 불가능함
		int sumOfNotEx = 0;
		int maxSum = 0;
		while (!curV.adj.isEmpty()) {
			int adjIndex = curV.adj.poll();

			if (adjIndex == parent)
				continue;
			treeDP(vIndex, adjIndex);

			sumOfNotEx += dp[adjIndex][0];
			maxSum += Math.max(dp[adjIndex][0], dp[adjIndex][1]);
		}

		dp[curV.villageIndex][1] = sumOfNotEx + villageTree[vIndex].population;
		dp[curV.villageIndex][0] = maxSum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = nextInt();
		villageTree = new Village[N + 1];
		dp = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			villageTree[i] = new Village(i, nextInt());
		}

		int a, b;
		for (int i = 0; i < N - 1; i++) {
			a = nextInt();
			b = nextInt();

			villageTree[a].add(b);
			villageTree[b].add(a);
		}

		treeDP(0, 1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
