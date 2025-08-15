import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] left, right, map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        left = new int[N + 2][M + 2];
        right = new int[N + 2][M + 2];
        map = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= N + 1; i++) {
            left[i][0] = right[i][0] = left[i][M + 1] = right[i][M + 1] = -100 * 1000 * 1000;
        }

        for (int j = 0; j <= M + 1; j++) {
            left[0][j] = right[0][j] = left[N + 1][j] = right[N + 1][j] = -100 * 1000 * 1000;
        }

        right[1][1] = map[1][1];
        left[1][1] = -100 * 1000 * 1000;
        for (int j = 2; j <= M; j++) {
            right[1][j] = right[1][j - 1] + map[1][j];
            left[1][j] = -100 * 1000 * 1000;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                right[i][j] = Math.max(Math.max(left[i - 1][j], right[i - 1][j]), right[i][j - 1]) + map[i][j];
            }
            for (int j = M; j >= 1; j--) {
                left[i][j] = Math.max(Math.max(left[i - 1][j], right[i - 1][j]), left[i][j + 1]) + map[i][j];
            }
        }

        System.out.println(Math.max(left[N][M], right[N][M]));
    }
}
