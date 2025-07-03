import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] dp;
    static boolean[] isFixed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        isFixed = new boolean[N+1];

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            isFixed[Integer.parseInt(br.readLine())] = true;
        }

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1];
            if(!isFixed[i] && !isFixed[i-1]){
                dp[i] += dp[i-2];
            }
        }

        System.out.println(dp[N]);
    }
}
