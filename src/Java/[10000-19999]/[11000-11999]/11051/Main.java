import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static final int MOD = 10007;
    static int[][] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        comb = new int[1001][1001];

        for (int i = 0; i <= 1000; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }

        System.out.println(comb[N][K]);
    }
}