import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M;
    static BigInteger[][] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comb = new BigInteger[101][101];
        for (int i = 0; i <= 100; i++) {
            comb[i][0] = new BigInteger("1");
            for (int j = 1; j < i; j++) {
                comb[i][j] = comb[i - 1][j - 1].add(comb[i - 1][j]);
            }
            comb[i][i] = new BigInteger("1");
        }

        System.out.println(comb[N][M]);
    }
}