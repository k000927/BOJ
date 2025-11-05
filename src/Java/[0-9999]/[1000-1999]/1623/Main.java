import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Node[] nodeList;
    static int[][] dp;
    static Queue<Integer> ansQueue;

    static class Node implements Comparable<Node> {
        int num, level, nal;
        List<Node> adj;

        Node(int num, int nal) {
            this.num = num;
            this.nal = nal;
            this.level = -1;
            this.adj = new ArrayList<>();
        }

        public void addChild(Node n) {
            adj.add(n);
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(n.level, this.level);
        }

    }

    static void getPath(int num, boolean flag) {
        Node cur = nodeList[num];
        if (flag) {
            ansQueue.add(num);
            for (Node child : cur.adj) {
                if (child.level < cur.level)
                    continue;
                getPath(child.num, false);
            }
        } else {
            for (Node child : cur.adj) {
                if (child.level < cur.level)
                    continue;
                if (dp[0][child.num] > dp[1][child.num])
                    getPath(child.num, false);
                else
                    getPath(child.num, true);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nodeList = new Node[N + 1];
        dp = new int[2][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int nal = Integer.parseInt(st.nextToken());
            nodeList[i] = new Node(i, nal);
            dp[1][i] = nal;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= N; i++) {
            nodeList[Integer.parseInt(st.nextToken())].addChild(nodeList[i]);
        }

        nodeList[1].level = 1;
        Queue<Node> levelQueue = new PriorityQueue<>();
        levelQueue.add(nodeList[1]);

        while (!levelQueue.isEmpty()) {
            Node cur = levelQueue.poll();
            for (Node child : cur.adj) {
                if (child.level != -1)
                    continue;
                child.level = cur.level + 1;
                levelQueue.add(child);
            }
        }

        Queue<Node> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            queue.add(nodeList[i]);
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 해당 직원이 참여하지 않는 경우
            for (Node child : cur.adj) {
                if (child.level < cur.level)
                    continue;
                if (dp[0][child.num] > dp[1][child.num]) {
                    dp[0][cur.num] += dp[0][child.num];
                } else {
                    dp[0][cur.num] += dp[1][child.num];
                }
            }


            // 해당 직원이 참여하는 경우
            for (Node child : cur.adj) {
                if (child.level < cur.level)
                    continue;
                dp[1][cur.num] += dp[0][child.num];
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(dp[1][1]).append(' ').append(dp[0][1]).append('\n');

        ansQueue = new PriorityQueue<>();
        getPath(1, true);
        while (!ansQueue.isEmpty()) {
            ans.append(ansQueue.poll()).append(' ');
        }
        ans.append(-1).append('\n');

        getPath(1, false);
        while (!ansQueue.isEmpty()) {
            ans.append(ansQueue.poll()).append(' ');
        }
        ans.append(-1).append('\n');
        System.out.println(ans);
    }
}
