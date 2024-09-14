import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class Main {
    static int r1;
    static int c1;
    static int r2;
    static int c2;
    static int num = 1;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] ans;

    static int x;
    static int y;

    static boolean putNumber(int length) {
        int dir1 = 0;
        int dir2 = 1;
        if (length % 2 == 0) {
            dir1 += 2;
            dir2 += 2;
        }

        for (int i = 0; i < length; i++) {
            x += dx[dir1];
            y += dy[dir1];
            if (x < 0 || x > 10000 || y < 0 || y > 10000) {
                return false;
            }
            num++;
            if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                ans[x - r1][y - c1] = num;
            }
        }

        for (int i = 0; i < length; i++) {
            x += dx[dir2];
            y += dy[dir2];
            if (x < 0 || x > 10000 || y < 0 || y > 10000) {
                return false;
            }
            num++;
            if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                ans[x - r1][y - c1] = num;
            }
        }

        return true;
    }

    static void setWhirl() {
        x = 5000;
        y = 5000;
        if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
            ans[x - r1][y - c1] = num;
        }
        int length = 1;
        while (putNumber(length++)) {
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken()) + 5000;
        c1 = Integer.parseInt(st.nextToken()) + 5000;
        r2 = Integer.parseInt(st.nextToken()) + 5000;
        c2 = Integer.parseInt(st.nextToken()) + 5000;

        ans = new int[r2 - r1 + 1][c2 - c1 + 1];

        setWhirl();

        int maxSize = String.valueOf(max(max(ans[0][0], ans[0][c2 - c1]), max(ans[r2 - r1][0], ans[r2 - r1][c2 - c1]))).length();


        for (int i = 0; i < r2 - r1 + 1; i++) {
            for (int j = 0; j < c2 - c1 + 1; j++) {
                System.out.print(String.format("%" + maxSize + "d", ans[i][j]) + " ");
            }
            System.out.println();
        }
    }
}