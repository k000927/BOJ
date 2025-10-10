import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static int[][] map;

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static int ans;

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int h) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        visited[x][y] = true;

        boolean isPeak = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[nx][ny] > h)
                    isPeak = false;
                if (visited[nx][ny])
                    continue;
                if (map[nx][ny] == h) {
                    visited[nx][ny] = true;
                    q.add(new Pos(nx, ny));
                }
            }
        }

        if (isPeak) ans++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                bfs(i, j, map[i][j]);
            }
        }

        System.out.println(ans);
    }
}