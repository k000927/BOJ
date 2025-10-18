import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp, color;
    static int[] ans;
    static Node[] nodeList;

    static class Node implements Comparable<Node> {
        int num, level;
        List<Node> adj;

        Node(int num) {
            this.num = num;
            this.level = -1;
            adj = new ArrayList<>();
        }

        public void addAdj(int num) {
            adj.add(nodeList[num]);
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.level, this.level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nodeList = new Node[N + 1];
        dp = new int[3][N + 1];
        color = new int[3][N + 1];
        ans = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            nodeList[i] = new Node(i);
            dp[0][i] = dp[1][i] = dp[2][i] = 0;
            ans[i] = -1;
        }


        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeList[a].addAdj(b);
            nodeList[b].addAdj(a);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            color[0][i] = a;
            color[1][i] = b;
            color[2][i] = c;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(nodeList[1]);
        nodeList[1].level = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node next : node.adj) {
                if (next.level != -1)
                    continue;
                next.level = node.level + 1;
                queue.add(next);
            }
        }

        queue = new PriorityQueue<>();
        queue.addAll(Arrays.asList(nodeList).subList(1, N + 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            dp[0][node.num] = color[0][node.num];
            dp[1][node.num] = color[1][node.num];
            dp[2][node.num] = color[2][node.num];

            for (Node child : node.adj) {
                if (child.level < node.level)
                    continue;

                dp[0][node.num] += Math.max(dp[1][child.num], dp[2][child.num]);
                dp[1][node.num] += Math.max(dp[0][child.num], dp[2][child.num]);
                dp[2][node.num] += Math.max(dp[0][child.num], dp[1][child.num]);
            }
        }

        int max = 0;
        int maxVal = dp[0][1];
        for (int i = 1; i < 3; i++) {
            if (dp[i][1] > maxVal) {
                maxVal = dp[i][1];
                max = i;
            }
        }


        ans[1] = max;
        queue = new LinkedList<>();
        queue.add(nodeList[1]);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int color = ans[curr.num];
            for (Node child : curr.adj) {
                if (child.level < curr.level)
                    continue;
                int nextColor = 0;
                if (color == 0) {
                    nextColor = dp[1][child.num] > dp[2][child.num] ? 1 : 2;
                } else if (color == 1) {
                    nextColor = dp[0][child.num] > dp[2][child.num] ? 0 : 2;
                } else {
                    nextColor = dp[0][child.num] > dp[1][child.num] ? 0 : 1;
                }
                ans[child.num] = nextColor;
                queue.add(child);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[max][1]).append('\n');
        for (int i = 1; i <= N; i++) {
            if (ans[i] == 0)
                sb.append('R');
            else if (ans[i] == 1)
                sb.append('G');
            else
                sb.append('B');
        }
        System.out.println(sb);
    }
}