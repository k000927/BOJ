import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] pool;
    static boolean[][] visited;
    static Queue<Pos> queue;
    static Queue<Pos> pourQueue;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void pour(int x, int y, int level) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        queue.clear();
        pourQueue.clear();

        Pos pos = new Pos(x, y);
        queue.add(pos);
        pourQueue.add(pos);
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)
                    return;

                if (pool[nx][ny] < level)
                    return;

                if (visited[nx][ny] || pool[nx][ny] != level)
                    continue;

                visited[nx][ny] = true;

                Pos nextPos = new Pos(nx, ny);
                queue.add(nextPos);
                pourQueue.add(nextPos);
            }
        }

        while (!pourQueue.isEmpty()) {
            Pos cur = pourQueue.poll();

            ans++;
            pool[cur.x][cur.y]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        pourQueue = new LinkedList<>();

        pool = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                pool[i][j] = input.charAt(j) - '0';
            }
        }

        for (int level = 1; level < 9; level++) {
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (pool[i][j] != level)
                        continue;
                    pour(i, j, level);
                }
            }
        }

        System.out.println(ans);
    }
}