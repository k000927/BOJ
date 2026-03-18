import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final double P = (double) 1 / 6;
    static double[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new double[1000001];

        dp[1] = 1.0;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0)
                    dp[i] += P * (dp[i - j] + 1);
                else
                    dp[i] += P;
            }
        }

        System.out.println(dp[N]);
    }
}