import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] dp;
    static Node[] nodeArr;

    static class Node implements Comparable<Node> {
        int num, level;
        List<Node> children;

        Node(int num) {
            this.num = num;
            this.children = new ArrayList<>();
        }

        public void addChild(int child) {
            this.children.add(nodeArr[child]);
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
        dp = new long[N];
        nodeArr = new Node[N];

        for (int i = 0; i < N; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodeArr[p].addChild(c);
        }

        Queue<Node> queue = new LinkedList<>();
        nodeArr[0].level = 0;
        queue.add(nodeArr[0]);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node child : node.children) {
                child.level = node.level + 1;
                queue.add(child);
            }
        }

        queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = Long.parseLong(st.nextToken());
            queue.add(nodeArr[i]);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node child : node.children) {
                dp[node.num] = Math.max(dp[child.num] + dp[node.num], dp[node.num]);
            }
        }

        System.out.println(dp[0]);
    }
}