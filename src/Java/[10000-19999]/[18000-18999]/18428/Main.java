import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean ans;

    static boolean isWatchable(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int dist = 1;
            while (true) {
                int nx = x + dx[i] * dist;
                int ny = y + dy[i] * dist;

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    break;

                if (map[nx][ny] == 'O')
                    break;

                if (map[nx][ny] == 'T')
                    return true;

                dist++;
            }
        }

        return false;
    }

    static void judge() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S' && isWatchable(i, j)) {
                    return;
                }
            }
        }

        ans = true;
    }

    static void backTrack(int x, int y, int cnt) {
        int nx = x, ny = y + 1;
        if (ny == N) {
            if (++nx == N)
                return;
            else
                ny = 0;
        }

        if (map[x][y] == 'X') {
            map[x][y] = 'O';
            if (cnt + 1 == 3)
                judge();
            else
                backTrack(nx, ny, cnt + 1);
        }

        if (map[x][y] == 'O') {
            map[x][y] = 'X';
        }

        backTrack(nx, ny, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        backTrack(0, 0, 0);

        System.out.println(ans ? "YES" : "NO");

    }
}
