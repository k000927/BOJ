import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int c, N, M, cnt, minDist;
    static char[][] input, map;
    static int[][] labyrinth;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static String ans;

    static String mapToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N * 4 + 1; i++) {
            sb.append(map[i]).append('\n');
        }
        return sb.toString();
    }

    static void dfs(int x, int y, int dist) {
        // 도착했을 때
        if ((x == N * 4 && y == M * 4 - 2) || (x == N * 4 - 2 && y == M * 4)) {
            if (dist <= minDist) {
                minDist = dist;
                ans = mapToString();
            }
            cnt++;
            return;
        }

        int nx, ny;
        if (map[x][y] != '-' && map[x][y] != '|') {
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || nx >= 4 * N + 1 || ny < 0 || ny >= 4 * M + 1)
                    continue;

                if (map[nx][ny] == ' ' || map[nx][ny] == '+')
                    continue;

                if (visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                dfs(nx, ny, dist + 1);
                visited[nx][ny] = false;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i] * 2;
                ny = y + dy[i] * 2;

                if (nx < 0 || nx >= 4 * N + 1 || ny < 0 || ny >= 4 * M + 1)
                    continue;

                if (map[nx][ny] == '|' || map[nx][ny] == '-' || map[nx][ny] == '+')
                    continue;

                if (visited[nx][ny])
                    continue;

                if (labyrinth[nx / 4][ny / 4] == 0)
                    continue;

                if (labyrinth[nx / 4][ny / 4] == 1) {
                    for (int j = 1; j <= 3; j++) {
                        map[x + dx[i] * j][y + dy[i] * j] = '*';
                    }

                    visited[x + dx[i]][y + dy[i]] = true;
                    dfs(x + dx[i], y + dy[i], dist + 1);
                    visited[x + dx[i]][y + dy[i]] = false;


                    for (int j = 1; j <= 3; j++) {
                        map[x + dx[i] * j][y + dy[i] * j] = ' ';
                    }
                }

                if (labyrinth[nx / 4][ny / 4] == 2) {
                    map[x + dx[i]][y + dy[i]] = map[x + dx[i] * 2][y + dy[i] * 2] = map[x + dx[i] * 2 + dx[(i + 1) % 4]][y + dy[i] * 2 + dy[(i + 1) % 4]] = '*';

                    visited[x + dx[i]][y + dy[i]] = true;
                    dfs(x + dx[i], y + dy[i], dist + 1);
                    visited[x + dx[i]][y + dy[i]] = false;

                    map[x + dx[i]][y + dy[i]] = map[x + dx[i] * 2][y + dy[i] * 2] = map[x + dx[i] * 2 + dx[(i + 1) % 4]][y + dy[i] * 2 + dy[(i + 1) % 4]] = ' ';

                    map[x + dx[i]][y + dy[i]] = map[x + dx[i] * 2][y + dy[i] * 2] = map[x + dx[i] * 2 + dx[(i + 3) % 4]][y + dy[i] * 2 + dy[(i + 3) % 4]] = '*';

                    visited[x + dx[i]][y + dy[i]] = true;
                    dfs(x + dx[i], y + dy[i], dist + 1);
                    visited[x + dx[i]][y + dy[i]] = false;

                    map[x + dx[i]][y + dy[i]] = map[x + dx[i] * 2][y + dy[i] * 2] = map[x + dx[i] * 2 + dx[(i + 3) % 4]][y + dy[i] * 2 + dy[(i + 3) % 4]] = ' ';
                }
            }
        }
    }

    static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minDist = Integer.MAX_VALUE;
        cnt = 0;
        ans = "";

        input = new char[N * 4 + 1][M * 4 + 1];
        map = new char[N * 4 + 1][M * 4 + 1];
        visited = new boolean[N * 4 + 1][M * 4 + 1];
        labyrinth = new int[N][M];

        String line;
        for (int i = 0; i < N * 4 + 1; i++) {
            line = br.readLine();
            for (int j = 0; j < M * 4 + 1; j++) {
                input[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < 4 * N + 1; i++) {
            for (int j = 0; j < 4 * M + 1; j++) {
                if (i % 4 == 0 && j % 4 == 0)
                    map[i][j] = '+';
                else if (i % 4 == 0)
                    map[i][j] = '-';
                else if (j % 4 == 0)
                    map[i][j] = '|';
                else
                    map[i][j] = ' ';
            }
        }


        int inputI, inputJ;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                inputI = i * 4 + 2;
                inputJ = j * 4 + 2;

                if (input[inputI][inputJ] == ' ')
                    labyrinth[i][j] = 0;

                else if ((input[inputI + 1][inputJ] == '*' && input[inputI - 1][inputJ] == '*') || (input[inputI][inputJ + 1] == '*' && input[inputI][inputJ - 1] == '*'))
                    labyrinth[i][j] = 1;

                else
                    labyrinth[i][j] = 2;
            }
        }

        // 위쪽 변에서 시작
        visited[0][2] = true;
        dfs(0, 2, 1);
        visited[0][2] = false;


        // 왼쪽 변에서 시작
        visited[2][0] = true;
        dfs(2, 0, 1);
        visited[2][0] = false;
    }

    public static void main(String[] args) throws IOException {
        c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (c-- > 0) {
            solve();
            sb.append(ans).append("Number of solutions: ").append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
