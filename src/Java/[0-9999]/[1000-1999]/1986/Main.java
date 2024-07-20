import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int[][] chess;
    static int[] queenX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] queenY = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] knightX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] knightY = {1, 2, 2, 1, -1, -2, -2, -1};

    private static void moveQueen(Pos queen) {
        int x = queen.x;
        int y = queen.y;
        for (int i = 0; i < 8; i++) {
            int curX = x;
            int curY = y;
            while (true) {
                curX += queenX[i];
                curY += queenY[i];
                if (curX < 0 || curX >= n) break;
                if (curY < 0 || curY >= m) break;
                if (chess[curX][curY] == 2) break;
                chess[curX][curY] = 1;
            }
        }
    }

    private static void moveKnight(Pos knight) {
        int x = knight.x;
        int y = knight.y;
        for (int i = 0; i < 8; i++) {
            int nextX = x + knightX[i];
            int nextY = y + knightY[i];
            if (nextX < 0 || nextX >= n) continue;
            if (nextY < 0 || nextY >= m) continue;
            chess[nextX][nextY] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 0: 가능 1: 불가능 2: 말 있음
        chess = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], 0);
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        Pos[] queens = new Pos[q];
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            queens[i] = new Pos(x, y);
            chess[x][y] = 2;
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        Pos[] knights = new Pos[k];
        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            knights[i] = new Pos(x, y);
            chess[x][y] = 2;
        }

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        for (int i = 0; i < p; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            chess[x][y] = 2;
        }

        for (Pos queen : queens) {
            moveQueen(queen);
        }

        for (Pos knight : knights) {
            moveKnight(knight);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chess[i][j] == 0) ans++;
            }
        }

        System.out.println(ans);
    }
}