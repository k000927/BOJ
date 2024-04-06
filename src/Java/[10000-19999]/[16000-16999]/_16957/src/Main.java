import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int R, C;
    public static Point[][] dp;
    public static int[][] result;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Point dfs(Point cur) {
        if (dp[cur.x][cur.y].x != -1) return dp[cur.x][cur.y];
        int minValue = map[cur.x][cur.y];
        int minX = 0;
        int minY = 0;
        for (int d = 0; d < 8; d++) {
            int X = cur.x + dx[d];
            int Y = cur.y + dy[d];
            if (X < 0 || Y < 0 || X >= R || Y >= C) continue;
            if (map[X][Y] < minValue) {
                minValue = map[X][Y];
                minX = X;
                minY = Y;
            }
        }
        //작은 값이 없는 경우
        if (minValue == map[cur.x][cur.y]) {
            return dp[cur.x][cur.y] = new Point(cur.x, cur.y);
        }
        //작은 값이 존재하는 경우
        else {
            return dp[cur.x][cur.y] = dfs(new Point(minX, minY));
        }
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dp = new Point[R][C];
        result = new int[R][C];
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                dp[i][j] = new Point(-1, -1);
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                Point res = dfs(new Point(i, j));
                result[res.x][res.y]++;
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                bw.write(result[i][j] + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        bw.close();
    }
}