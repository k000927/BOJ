import java.util.*;
import java.io.*;

class Main {

    static class Point {
        int x;
        int y;
        int cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s_r = Integer.parseInt(st.nextToken());
        int s_c = Integer.parseInt(st.nextToken());
        int f_r = Integer.parseInt(st.nextToken());
        int f_c = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<Point> queue = new ArrayDeque<>();
        Boolean[][] visited = new Boolean[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(visited[i], false);
        }
        queue.addFirst(new Point(s_r, s_c, 0));
        visited[s_r][s_c] = true;
        while (!queue.isEmpty()) {
            Point p = queue.removeFirst();
            if (p.x == f_r && p.y == f_c) {
                System.out.println(p.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x <= 0 || x > n || y <= 0 || y > m) {
                    continue;
                }
                if (x + h - 1 > n || y + w - 1 > m) {
                    continue;
                }
                if (visited[x][y]) {
                    continue;
                }
                Boolean flag = false;
                if (dx[i] == 0) {
                    for (int a = 0; a < h; a++) {
                        if (graph[x + a][y] == 1) {
                            flag = true;
                            break;
                        }
                        if (graph[x + a][y + w - 1] == 1) {
                            flag = true;
                            break;
                        }
                    }
                } else {
                    for (int a = 0; a < w; a++) {
                        if (graph[x][y + a] == 1) {
                            flag = true;
                            break;
                        }
                        if (graph[x + h - 1][y + a] == 1) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) continue;
                queue.addLast(new Point(x, y, p.cnt + 1));
                visited[x][y] = true;
            }
        }
        System.out.println(-1);
    }
}