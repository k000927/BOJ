import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

/*
 * Edge 클래스
 * 		- from: 출발 노드
 * 		- to: 도착 노드, 무향 그래프이므로 출발과 도착 노드 구분의 의미는 없지만 편의상 구분
 * 		- weight: 가중치, 정렬 기준이 됨
 * 
 * 크루스칼 알고리즘을 적용하여 풀이
 * 
 */

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	// 정점의 개수
	static int N;
	// 간선의 개수
	static int M;
	// 각 집합의 대푯값
	static int[] parents;

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		if (x > y)
			parents[y] = x;
		else
			parents[x] = y;
		return true;
	}

	static int kruskal(PriorityQueue<Edge> pq) {
		int edgeCount = 0;
		int edgeSum = 0;

		while (edgeCount < N - 1) {
			Edge e = pq.poll();

			if (union(e.from, e.to)) {
				edgeCount++;
				edgeSum += e.weight;
			}
		}

		return edgeSum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = nextInt();
		M = nextInt();
		parents = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			pq.add(new Edge(nextInt(), nextInt(), nextInt()));
		}

		System.out.println(kruskal(pq));
	}

	static private int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
