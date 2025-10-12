import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static Node[] nodeArr;

    static class Node implements Comparable<Node> {
        int num, level;
        List<Node> adj;

        Node(int num) {
            this.num = num;
            this.level = -1;
            adj = new ArrayList<>();
        }

        public void addAdj(int num) {
            adj.add(nodeArr[num]);
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.level, this.level);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "level=" + level +
                    ", num=" + num +
                    '}';
        }
    }

    static void setLevel() {
        Queue<Node> queue = new LinkedList<>();
        nodeArr[1].level = 0;
        queue.add(nodeArr[1]);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : cur.adj) {
                if (next.level != -1) {
                    continue;
                }
                next.level = cur.level + 1;
                queue.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodeArr = new Node[N + 1];
        dp = new int[2][N + 1];

        for (int i = 0; i <= N; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodeArr[u].addAdj(v);
            nodeArr[v].addAdj(u);
        }

        setLevel();

        Queue<Node> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            queue.add(nodeArr[i]);
            dp[0][i] = 100000;
            dp[1][i] = 100000;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int notWatch = 0;
            int watch = 0;

            for (Node child : cur.adj) {
                if (child.level < cur.level) {
                    continue;
                }

                notWatch += dp[1][child.num];
                watch += Math.min(dp[0][child.num], dp[1][child.num]);
            }

            dp[0][cur.num] = notWatch;
            dp[1][cur.num] = watch + 1;
        }

        System.out.println(Math.min(dp[0][1], dp[1][1]));
    }
}
