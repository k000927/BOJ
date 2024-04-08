import java.io.*;
import java.util.*;

public class Main {
    static List<Edge>[] graph;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int w;
        int cost;

        Edge(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    public static void prim(int start, int n) {
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int total = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;

            if (visited[v]) continue;

            visited[v] = true;
            total += cost;

            for (Edge e : graph[v]) {
                if (!visited[e.w]) {
                    pq.add(e);
                }
            }
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] info = new int[n][m];
        int[][] island = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Node> queue = new ArrayDeque<>();
        Boolean[][] visited = new Boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int island_idx = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (info[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                queue.add(new Node(i, j));
                visited[i][j] = true;
                island[i][j] = island_idx;
                while (!queue.isEmpty()) {
                    Node curNode = queue.remove();
                    for (int k = 0; k < 4; k++) {
                        int x = curNode.x + dx[k];
                        int y = curNode.y + dy[k];
                        if (x < 0 || x >= n || y < 0 || y >= m) {
                            continue;
                        }
                        if (info[x][y] == 0 || visited[x][y]) {
                            continue;
                        }
                        queue.add(new Node(x, y));
                        visited[x][y] = true;
                        island[x][y] = island_idx;
                    }
                }
                island_idx++;
            }
        }

        graph = new ArrayList[island_idx];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (island[i][j] == 0) {
                    continue;
                }
                int curIsland = island[i][j];
                for (int k = 0; k < 4; k++) {
                    int dist = -1;
                    int x = i;
                    int y = j;
                    while (true) {
                        dist++;
                        x += dx[k];
                        y += dy[k];
                        if (x < 0 || x >= n || y < 0 || y >= m) {
                            break;
                        }
                        if (island[x][y] == curIsland) {
                            break;
                        }
                        if (island[x][y] == 0) {
                            continue;
                        }
                        if (dist == 1) {
                            break;
                        }
                        int nextIsland = island[x][y];
                        graph[curIsland].add(new Edge(nextIsland, dist));
                        graph[nextIsland].add(new Edge(curIsland, dist));
                        break;
                    }
                }
            }
        }
        prim(1, island_idx - 1);
    }
}