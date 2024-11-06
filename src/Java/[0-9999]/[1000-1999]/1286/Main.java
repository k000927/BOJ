import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static char[][] rect;
    static long[] ans = new long[26];
    static long[][] rectNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rect = new char[n * 2][m * 2];
        rectNum = new long[n * 2][m * 2];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = temp.charAt(j);
                rect[i][j] = rect[i + n][j] = rect[i][j + m] = rect[i + n][j + m] = c;
            }
        }

        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j < m * 2; j++) {
                rectNum[i][j] = (long) (i + 1) * (j + 1) * (n * 2L - i) * (m * 2L - j);
            }
        }

        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j < m * 2; j++) {
                ans[rect[i][j] - 'A'] += rectNum[i][j];
            }
        }

        for (long num : ans) {
            System.out.println(num);
        }
    }
}