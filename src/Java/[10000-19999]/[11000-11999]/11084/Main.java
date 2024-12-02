import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = new int[]{1, -1, 1, -1, 2, 2, -2, -2};
    static int[] dy = new int[]{2, 2, -2, -2, 1, -1, 1, -1};
    static final int MOD = 1_000_000_009;
    static long[][] dp;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        return true;
    }

    static long getCnt() {
        LinkedList<Node> q = new LinkedList<>();

        q.add(new Node(0, 0));
        dp[0][0] = 1;
        long dist = 0;
        Node now;
        int nx, ny, qsize;
        while (!q.isEmpty()) {
            if (dp[n - 1][m - 1] != 0)
                break;

            qsize = q.size();
            dist++;
            while (qsize-- > 0) {
                now = q.poll();

                for (int i = 0; i < 8; i++) {
                    nx = now.x + dx[i];
                    ny = now.y + dy[i];
                    if (!inRange(nx, ny))
                        continue;
                    if (dp[nx][ny] == 0) {
                        q.add(new Node(nx, ny));
                    }
                    dp[nx][ny] += dp[now.x][now.y];
                    dp[nx][ny] %= MOD;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new long[n][m];

        long dist = getCnt();

        if (dp[n - 1][m - 1] == 0) {
            sb.append("None");
        } else {
            sb.append(dist).append(" ").append(dp[n - 1][m - 1]);
        }

        System.out.println(sb.toString());
    }
}