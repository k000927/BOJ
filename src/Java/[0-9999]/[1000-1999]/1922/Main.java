import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Edge 클래스
 * 		- from: 출발 노드
 * 		- to: 도착 노드, 무향 그래프이므로 출발과 도착 노드 구분의 의미는 없지만 편의상 구분
 * 		- weight: 가중치, 정렬 기준이 됨
 *
 * 프림 알고리즘을 적용하여 풀이
 *
 */

public class Main {
    static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    // 정점의 개수
    static int V;
    // 간선의 개수
    static int E;
    // 방문 여부
    static boolean[] visited;
    // 최소 길이 배열
    static int[] minEdge;
    // 가중치 배열
    static ArrayList<ArrayList<Edge>> cost;

    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }

    static int prim() {
        int result = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        int count = 0;

        while (count < V) {
            Edge e = pq.poll();

            if (visited[e.to])
                continue;

            visited[e.to] = true;
            count++;
            result += e.weight;

            for (Edge n : cost.get(e.to)) {
                if (!visited[n.to] && minEdge[n.to] > n.weight) {
                    minEdge[n.to] = n.weight;
                    pq.add(n);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        V = nextInt();
        E = nextInt();

        visited = new boolean[V + 1];
        minEdge = new int[V + 1];
        cost = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            minEdge[i] = Integer.MAX_VALUE;
            cost.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int from = nextInt();
            int to = nextInt();
            int weight = nextInt();
            cost.get(from).add(new Edge(to, weight));
            cost.get(to).add(new Edge(from, weight));
        }

        System.out.println(prim());
    }

    static private int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}