import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    static int N, M;
    static BigInteger K;
    static BigInteger[][] C;

    static String solve(int n, int m, BigInteger k, String cur) {
        if (n == 0 && m == 0) return cur;

        if (n == 0) return solve(n, m - 1, k, cur + "z");
        if (m == 0) return solve(n - 1, m, k, cur + "a");

        BigInteger comb = C[n + m - 1][n - 1];
        if (comb.compareTo(k) >= 0) {
            return solve(n - 1, m, k, cur + "a");
        } else {
            return solve(n, m - 1, k.subtract(comb), cur + "z");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = new BigInteger(st.nextToken());

        int max = N + M;
        C = new BigInteger[max + 1][max + 1];

        for (int i = 0; i <= max; i++) {
            C[i][0] = BigInteger.ONE;
            C[i][i] = BigInteger.ONE;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1].add(C[i - 1][j]);
            }
        }

        if (C[N + M][N].compareTo(K) < 0) {
            System.out.println(-1);
        } else {
            System.out.println(solve(N, M, K, ""));
        }
    }
}
