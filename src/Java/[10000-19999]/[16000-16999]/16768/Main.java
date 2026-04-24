import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean mooyo() {
        boolean flag = false;
        boolean[][] visited = new boolean[N][10];

        Queue<Pos> queue = new LinkedList<>();
        Queue<Pos> store = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    queue.clear();
                    store.clear();

                    queue.add(new Pos(i, j));
                    store.add(new Pos(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Pos p = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = p.x + dx[d];
                            int ny = p.y + dy[d];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= 10) continue;
                            if (visited[nx][ny]) continue;
                            if (map[nx][ny] != map[i][j]) continue;

                            visited[nx][ny] = true;
                            queue.add(new Pos(nx, ny));
                            store.add(new Pos(nx, ny));
                        }
                    }

                    if (store.size() >= K) {
                        flag = true;
                        while (!store.isEmpty()) {
                            Pos p = store.poll();
                            map[p.x][p.y] = 0;
                        }
                    }
                }
            }
        }

        return flag;
    }

    static void gravity() {
        for (int j = 0; j < 10; j++) {
            int h = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (map[i][j] == 0) continue;
                map[h--][j] = map[i][j];
            }

            for (int i = h; i >= 0; i--) {
                map[i][j] = 0;
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][10];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        while (mooyo()) {
            gravity();
        }

        print();
    }
}