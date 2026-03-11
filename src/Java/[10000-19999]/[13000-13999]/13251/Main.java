import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static int[] stone;
    static int N, M, K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        stone = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
            N += stone[i];
        }

        K = Integer.parseInt(br.readLine());

        BigDecimal ans = BigDecimal.ZERO;
        MathContext mc = new MathContext(30); // 정밀도 30자리

        for (int i = 0; i < M; i++) {

            if (stone[i] < K) continue;

            BigDecimal prob = BigDecimal.ONE;

            for (int j = 0; j < K; j++) {

                BigDecimal numerator =
                        BigDecimal.valueOf(stone[i] - j);

                BigDecimal denominator =
                        BigDecimal.valueOf(N - j);

                prob = prob.multiply(
                        numerator.divide(denominator, mc), mc
                );
            }

            ans = ans.add(prob);
        }

        System.out.println(ans);
    }
}