import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        comb = new int[9][9];
        for (int i = 0; i <= 8; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }

        double ans = 0;
        for (int i = K; i <= M; i++) {
            ans += (double) (comb[M][i] * comb[N - M][M - i]) / (comb[N][M]);
        }

        System.out.println(ans);
    }
}