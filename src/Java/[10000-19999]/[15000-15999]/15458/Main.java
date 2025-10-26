import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static final long MOD = 1000000007L;
    static long[][] dp; // dp[color][node]
    static Node[] nodeList;

    static class Node {
        int num, level, color;
        List<Node> adj;

        Node(int num) {
            this.num = num;
            this.level = -1;
            this.color = -1;
            adj = new ArrayList<>();
        }

        public void addAdj(Node n) {
            adj.add(n);
        }

        public void setColor(int color) {
            this.color = color;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new long[3][N + 1];
        nodeList = new Node[N + 1];
        for (int i = 1; i <= N; i++) nodeList[i] = new Node(i);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodeList[x].addAdj(nodeList[y]);
            nodeList[y].addAdj(nodeList[x]);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodeList[b].setColor(c - 1);
        }

        // 1) 루트(1)에서 BFS로 level 설정
        Queue<Node> q = new LinkedList<>();
        nodeList[1].level = 0;
        q.add(nodeList[1]);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nxt : cur.adj) {
                if (nxt.level == -1) {
                    nxt.level = cur.level + 1;
                    q.add(nxt);
                }
            }
        }

        // 2) 레벨 내림차순으로 처리하기 위해 노드들을 레벨 기준으로 정렬
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) nodes[i] = nodeList[i + 1];
        Arrays.sort(nodes, (a, b) -> Integer.compare(b.level, a.level)); // 높은 레벨(말단)부터

        // 3) DP: 각 노드에 대해 색 하나씩 계산
        for (Node node : nodes) {
            // 자식(레벨이 더 큰 이웃) 리스트 계산
            List<Node> children = new ArrayList<>();
            for (Node nei : node.adj) {
                if (nei.level > node.level) children.add(nei);
            }

            for (int curColor = 0; curColor < 3; curColor++) {
                // 색이 지정되어 있으면 다른 색은 불가능
                if (node.color != -1 && node.color != curColor) {
                    dp[curColor][node.num] = 0;
                    continue;
                }

                // 자식이 없으면 (말단) 이 색 하나로 1가지
                if (children.isEmpty()) {
                    dp[curColor][node.num] = 1;
                    continue;
                }

                int c1 = (curColor + 1) % 3;
                int c2 = (curColor + 2) % 3;
                long ways = 1L;
                for (Node child : children) {
                    long childWays = (dp[c1][child.num] + dp[c2][child.num]) % MOD; // 자식이 가질 수 있는 경우의 수 (두 색 합)
                    ways = (ways * childWays) % MOD;
                    if (ways == 0) break; // 최적화
                }
                dp[curColor][node.num] = ways;
            }
        }

        long ans = (dp[0][1] + dp[1][1] + dp[2][1]) % MOD;
        System.out.println(ans);
    }
}
