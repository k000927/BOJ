import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result;
    static int black;
    static int white;

    static int[][] map;
    static int[][] chess;
    static int[][] deltas = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        chess = new int[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chess[i][j] = (i + j) % 2;
            }
        }
        dfs(0, 0, chess[0][0], 0);
        dfs(0, 1, chess[0][1], 0);
        result = black + white;
        System.out.println(result);
    }

    public static void dfs(int y, int x, int color, int count) {
        if (y >= N) {
            if (color == 0) {
                black = Math.max(black, count);
            } else {
                white = Math.max(white, count);
            }
            return;
        }

        int nx = x + 2;
        int ny = y;

        if (nx >= N) {
            ny++;
            if (ny < N) {
                if (chess[ny][0] == color) {
                    nx = 0;
                } else {
                    nx = 1;
                }
            }
        }

        if (map[y][x] == 0) {
            dfs(ny, nx, color, count);
            return;
        }

        if (check(y, x)) {
            visited[y][x] = true;
            dfs(ny, nx, color, count + 1);
            visited[y][x] = false;
        }

        dfs(ny, nx, color, count);
    }

    public static boolean check(int x, int y) {
        int goCnt = 0;
        for (int dir = 0; dir < 4; dir++) {
            if (go(x, y, dir)) goCnt++;
        }
        if (goCnt < 4) return false;
        return true;
    }

    public static boolean go(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        while (true) {
            nx += deltas[dir][0];
            ny += deltas[dir][1];
            if (nx < 0 || N <= nx || ny < 0 || N <= ny) break;
            if (visited[nx][ny]) return false;
        }
        return true;
    }
}