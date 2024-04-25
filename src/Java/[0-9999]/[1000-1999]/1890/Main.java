import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.*;

public class Main {
    static Long[][] dp;
    static int[][] board;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int n;

    static class Node {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static void route(int x, int y) {
        if (board[x][y] == 0) return;
        for (int i = 0; i < 2; i++) {
            int nextX = x + dx[i] * board[x][y];
            int nextY = y + dy[i] * board[x][y];
            if (nextX >= n || nextY >= n) continue;
            dp[nextX][nextY] += dp[x][y];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new Long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0L);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1L;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0L) continue;
                route(i, j);
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}