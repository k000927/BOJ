import java.io.*;
import java.util.*;

public class Main {
    static int N, MOD = 1_000_000_007;
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        card = new int[(N = Integer.parseInt(br.readLine())) + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[Integer.parseInt(st.nextToken())]++;
        }

        long ans = 1L;
        for (int i = 1; i <= N; i++) {
            ans *= (card[i] + 1);
            ans %= MOD;
        }

        System.out.println((ans - 1 + MOD) % MOD);    }
}