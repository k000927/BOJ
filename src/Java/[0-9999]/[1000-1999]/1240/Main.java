import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static List<List<Node>> adj;

    static class Node implements Comparable<Node> {
        int num, weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        }
    }

    static Queue<Node> queue;

    static int bfs(int src, int dest) {
        Arrays.fill(visited, false);
        queue = new PriorityQueue<>();

        queue.add(new Node(src, 0));
        visited[src] = true;

        Node curNode;
        while (!queue.isEmpty()) {
            curNode = queue.poll();

            for (Node node : adj.get(curNode.num)) {
                if (visited[node.num])
                    continue;

                if (node.num == dest)
                    return curNode.weight + node.weight;

                visited[node.num] = true;
                queue.add(new Node(node.num, curNode.weight + node.weight));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        adj = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        int a, b, c;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }

        int src, dest;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            src = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());

            ans.append(bfs(src, dest)).append('\n');
        }

        System.out.print(ans);
    }
}
