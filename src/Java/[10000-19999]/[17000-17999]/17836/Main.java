import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node implements Comparable<Node> {
        int x, y, cnt;
        boolean gram;

        Node(int x, int y, int cnt, boolean gram) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.gram = gram;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(cnt, n.cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0][0] = true;
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 0, false));

        Node cur;
        int nx, ny;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (visited[nx][ny][cur.gram ? 1 : 0])
                    continue;

                if (map[nx][ny] == 1 && !cur.gram)
                    continue;

                if (nx == N - 1 && ny == M - 1 && cur.cnt + 1 <= T) {
                    System.out.println(cur.cnt + 1);
                    System.exit(0);
                }

                visited[nx][ny][cur.gram ? 1 : 0] = true;
                if (map[nx][ny] == 2) {
                    queue.add(new Node(nx, ny, cur.cnt + 1, true));
                    visited[nx][ny][1] = true;
                } else {
                    queue.add(new Node(nx, ny, cur.cnt + 1, cur.gram));
                    visited[nx][ny][cur.gram ? 1 : 0] = true;
                }
            }
        }

        System.out.println("Fail");
    }
}
