import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;

    static int[][] map;
    static int[][] row;
    static int[][] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        map = new int[n][m];
        row = new int[n][m];
        col = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = k; i < n - k; i++) {

            for (int j = 0; j <= 2 * k; j++) {
                row[i][k] += map[i][j];
            }

            for (int j = k + 1; j < m - k; j++) {
                row[i][j] = row[i][j - 1] - map[i][j - k - 1] + map[i][j + k];
            }
        }

        for (int j = k; j < m - k; j++) {

            for (int i = 0; i <= 2 * k; i++) {
                col[k][j] += map[i][j];
            }

            for (int i = k + 1; i < n - k; i++) {
                col[i][j] = col[i - 1][j] - map[i - k - 1][j] + map[i + k][j];
            }
        }

        int ans = 0;
        for (int i = k; i < n - k; i++) {
            for (int j = k; j < m - k; j++) {
                if (col[i][j] + row[i][j] == 2 * (2 * k + 1)) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}