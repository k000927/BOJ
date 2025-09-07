import java.io.*;
import java.util.*;

public class Main {
    static int C, N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[C + 101];
        Arrays.fill(dp, 1000000000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            for (int j = p; j < C + 101; j++) {
                dp[j] = Math.min(dp[j], c + dp[j - p]);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = C; i < C+101; i++) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }
}