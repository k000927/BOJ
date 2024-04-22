import java.io.*;
import java.util.*;

public class Main {

    static int[] sand_dx = {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0};
    static int n;
    static int[] sand_dy = {0, -1, 0, 1, -2, -1, 0, 1, 0, -1};
    static double[] ratio = {0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02, 0};
    static int[][] sand;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        sand = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sand[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cur_x = n / 2;
        int cur_y = n / 2;


        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int idx = 0;

        for (double dist = 1; ; dist += 0.5) {
            int cur_dist = (int) dist;
            for (int i = 0; i < cur_dist; i++) {
                cur_x += dx[idx % 4];
                cur_y += dy[idx % 4];
                hurricane(cur_x, cur_y, idx % 4);
                if (cur_x == 0 && cur_y == 0) {
                    System.out.println(ans);
                    return;
                }
            }
            idx++;
        }
    }

    private static void hurricane(int x, int y, int dir) {
        int next_x;
        int next_y;
        int left_sand = sand[x][y];
        for (int i = 0; i < 10; i++) {
            if (dir == 0) {
                next_x = x + sand_dx[i];
                next_y = y + sand_dy[i];
            } else if (dir == 1) {
                next_x = x - sand_dy[i];
                next_y = y - sand_dx[i];
            } else if (dir == 2) {
                next_x = x - sand_dx[i];
                next_y = y - sand_dy[i];
            } else {
                next_x = x + sand_dy[i];
                next_y = y + sand_dx[i];
            }
            int s = (int) Math.floor(sand[x][y] * ratio[i]);
            if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= n) {
                if (i == 9) {
                    ans += left_sand;
                } else {
                    ans += s;
                    left_sand -= s;
                }
                continue;
            }
            if (i == 9) {
                sand[next_x][next_y] += left_sand;
            } else {
                left_sand -= s;
                sand[next_x][next_y] += s;
            }
        }
        sand[x][y] = 0;
    }
}