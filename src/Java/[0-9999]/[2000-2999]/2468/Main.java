import java.io.*;
import java.util.*;

public class Main {

    static int[][] ground;
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int getSafe(int h) {
        int safe = 0;
        Boolean[][] visited = new Boolean[n][n];
        Deque<Point> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (ground[i][j] <= h) continue;

                safe++;
                q.add(new Point(i, j));
                visited[i][j] = true;

                while (!q.isEmpty()) {
                    Point curPoint = q.removeFirst();

                    int x = curPoint.x;
                    int y = curPoint.y;
                    int next_x = -1;
                    int next_y = -1;
                    for (int k = 0; k < 4; k++) {
                        next_x = x + dx[k];
                        next_y = y + dy[k];

                        if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= n) continue;
                        if (visited[next_x][next_y]) continue;
                        if (ground[next_x][next_y] <= h) continue;

                        visited[next_x][next_y] = true;
                        q.addLast(new Point(next_x, next_y));
                    }
                }
            }
        }
        return safe;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ground = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; ; i++) {
            int temp = getSafe(i);
            if (temp == 0) break;
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }
}