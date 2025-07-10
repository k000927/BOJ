import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int x, y, t, n;

        Node(int x, int y, int t, int n) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.n = n;
        }

        @Override
        public int compareTo(Node n) {
            if (this.t != n.t) return Integer.compare(this.t, n.t);
            return Integer.compare(this.n, n.n);
        }
    }

    static int N, K, S, X, Y;
    static int[][] map;
    static Queue<Node> queue;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void bfs() {
        Node curNode;
        int nx, ny, nt;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = curNode.x + dx[i];
                ny = curNode.y + dy[i];
                nt = curNode.t + 1;

                if (nx <= 0 || ny <= 0 || nx > N || ny > N)
                    continue;

                if (map[nx][ny] != 0)
                    continue;

                if (nt > S)
                    continue;

                map[nx][ny] = curNode.n;
                queue.add(new Node(nx, ny, nt, curNode.n));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) queue.add(new Node(i, j, 0, map[i][j]));
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(map[X][Y]);
    }
}
