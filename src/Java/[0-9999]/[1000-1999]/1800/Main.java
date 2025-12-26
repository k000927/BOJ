import java.io.*;
import java.util.*;

public class Main {
    static int N, P, K;
    static int[] dist;
    static List<List<Edge>> adj;
    static final int INF = 1_000_000_000;

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int v, cost; // cost = 비싼 간선 개수
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static boolean dijkstra(int mid) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);

        dist[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.v]) continue;

            for (Edge e : adj.get(cur.v)) {
                int nextCost = cur.cost;
                if (e.weight > mid) nextCost++;

                if (nextCost < dist[e.to]) {
                    dist[e.to] = nextCost;
                    pq.add(new Node(e.to, nextCost));
                }
            }
        }

        return dist[N] <= K;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        int left = 0, right = 0;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj.get(from).add(new Edge(to, weight));
            adj.get(to).add(new Edge(from, weight));
            right = Math.max(right, weight);
        }

        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (dijkstra(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
