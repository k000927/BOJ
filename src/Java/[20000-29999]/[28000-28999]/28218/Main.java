import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, Q;
    static char[][] map;
    static boolean[][] res;

    static int[] dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N + 1][M + 1];
        res = new boolean[N + 1][M + 1];
        dx = new int[K + 2];
        dy = new int[K + 2];

        dx[0] = dy[1] = 0;
        dx[1] = dy[0] = 1;
        for (int i = 0; i < K; i++) {
            dx[i + 2] = dy[i + 2] = i + 1;
        }

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        for (int i = N; i > 0; i--) {
            for (int j = M; j > 0; j--) {
                boolean temp = false;

                for (int k = 0; k < K + 2; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx > N || ny > M || map[nx][ny] == '#')
                        continue;

                    temp |= !res[nx][ny];
                }

                res[i][j] = temp;
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ans.append(res[x][y] ? "First" : "Second").append('\n');
        }

        System.out.print(ans);
    }
}