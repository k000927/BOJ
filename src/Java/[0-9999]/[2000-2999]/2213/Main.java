import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] W;
    static boolean[] visited;
    static int[][] dp;
    static PriorityQueue[][] path;
    static Node[] nodeArr;

    static class Node implements Comparable<Node> {
        int num, level;
        Node parent;
        List<Node> child;

        Node(int num) {
            this.num = num;
            child = new ArrayList<>();
        }

        public void addChild(int num) {
            this.child.add(nodeArr[num]);
        }

        public void setParent(int num) {
            this.parent = nodeArr[num];
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(n.level, this.level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = new int[N + 1];
        visited = new boolean[N + 1];
        dp = new int[2][N + 1];
        path = new PriorityQueue[2][N + 1];
        nodeArr = new Node[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
            nodeArr[i] = new Node(i);

            path[0][i] = new PriorityQueue<>();
            path[1][i] = new PriorityQueue<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (nodeArr[a].parent == null && nodeArr[b].parent == null) {
                nodeArr[Math.min(a, b)].addChild(Math.max(a, b));
                nodeArr[Math.min(a, b)].level = 0;

                nodeArr[Math.max(a, b)].setParent(Math.min(a, b));
                nodeArr[Math.max(a, b)].level = 1;
            } else if (nodeArr[a].parent == null) {
                nodeArr[b].addChild(a);
                nodeArr[a].setParent(b);
                nodeArr[a].level = nodeArr[b].level + 1;
            } else {
                nodeArr[a].addChild(b);
                nodeArr[b].setParent(a);
                nodeArr[b].level = nodeArr[a].level + 1;
            }
        }

        Queue<Node> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (nodeArr[i].child.isEmpty())
                queue.add(nodeArr[i]);
        }

        int ans = 0;
        Queue<Integer> ansP = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            dp[1][node.num] = W[node.num];
            path[1][node.num].add(node.num);
            for (Node child : node.child) {
                dp[1][node.num] += dp[0][child.num];
                path[1][node.num].addAll(path[0][child.num]);

                if (dp[0][child.num] > dp[1][child.num]) {
                    dp[0][node.num] += dp[0][child.num];
                    path[0][node.num].addAll(path[0][child.num]);
                } else {
                    dp[0][node.num] += dp[1][child.num];
                    path[0][node.num].addAll(path[1][child.num]);
                }
            }

            if (ans < dp[0][node.num]) {
                ans = dp[0][node.num];
                ansP = path[0][node.num];
            }

            if (ans < dp[1][node.num]) {
                ans = dp[1][node.num];
                ansP = path[1][node.num];
            }

            if (node.parent != null && !visited[node.parent.num]) {
                visited[node.parent.num] = true;
                queue.add(node.parent);
            }
        }

        System.out.println(ans);
        while (!ansP.isEmpty()) {
            System.out.print(ansP.poll() + " ");
        }
    }
}