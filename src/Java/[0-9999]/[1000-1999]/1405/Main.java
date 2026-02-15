import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double ans = 1;
    static double[] prob = new double[4];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    static void dfs(int x, int y, int count, double p) {
        if (count == N)
            return;

        for (int i = 0; i < 4; i++) {
            if (prob[i] == 0) continue;

            double nextP = p * prob[i];
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (visited[nx][ny]) {
                ans -= nextP;
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, count + 1, nextP);
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        prob[0] = (double) Integer.parseInt(st.nextToken()) / 100;
        prob[1] = (double) Integer.parseInt(st.nextToken()) / 100;
        prob[2] = (double) Integer.parseInt(st.nextToken()) / 100;
        prob[3] = (double) Integer.parseInt(st.nextToken()) / 100;

        visited = new boolean[31][31];
        visited[N][N] = true;

        dfs(N, N, 0, 1);
        System.out.println(ans);
    }
}
