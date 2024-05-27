import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int num;
        int cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    static List<PriorityQueue<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new PriorityQueue<>());
        }
        Boolean[] visited = new Boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            while (!graph.get(node.num).isEmpty()) {
                Node nextNode = graph.get(node.num).poll();

                if (visited[nextNode.num]) continue;
                if (dist[nextNode.num] <= node.cost + nextNode.cost) continue;

                pq.add(new Node(nextNode.num, node.cost + nextNode.cost));
                dist[nextNode.num] = node.cost + nextNode.cost;
            }
        }

        System.out.println(dist[n]);
    }
}