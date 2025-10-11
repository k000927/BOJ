import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T;
    static Node[] nodeArr;
    static boolean[] visited;
    static int[] dp;

    static class Node implements Comparable<Node> {
        int num, level;
        ArrayList<Edge> adj;

        Node(int num) {
            this.num = num;
            this.level = -1;
            this.adj = new ArrayList<>();
        }

        public void addAdj(int num, int weight) {
            this.adj.add(new Edge(num, weight));
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.level, this.level);
        }
    }

    static class Edge {
        int num, weight;

        Edge(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            nodeArr = new Node[N + 1];
            dp = new int[N + 1];
            visited = new boolean[N + 1];
            for (int i = 0; i <= N; i++) {
                nodeArr[i] = new Node(i);
                dp[i] = 100000;
            }
            nodeArr[1].level = 0;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int D = Integer.parseInt(st.nextToken());

                nodeArr[a].addAdj(b, D);
                nodeArr[b].addAdj(a, D);
            }

            Queue<Node> queue = new PriorityQueue<>();
            queue.add(nodeArr[1]);
            int maxLevel = 0;

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                maxLevel = Math.max(maxLevel, cur.level);
                for (Edge edge : cur.adj) {
                    Node next = nodeArr[edge.num];
                    if (next.level != -1) {
                        continue;
                    }
                    next.level = cur.level + 1;
                    queue.add(next);
                }
            }

            for (int i = 1; i <= N; i++) {
                if (i != 1 && nodeArr[i].adj.size() == 1) {
                    continue;
                }
                queue.add(nodeArr[i]);
            }

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                int sum = 0;
                for (Edge adj : cur.adj) {
                    if(nodeArr[adj.num].level < cur.level) {
                        continue;
                    }
                    sum += Math.min(dp[adj.num], adj.weight);
                }
                dp[cur.num] = sum;
            }

            System.out.println(dp[1]);
        }
    }
}