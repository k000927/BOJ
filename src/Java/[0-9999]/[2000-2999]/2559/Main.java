import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MIN_VALUE, sum = 0;


        for (int i = 0; i < K - 1; i++) {
            sum += c[i];
        }

        for (int i = K - 1; i < N; i++) {
            sum += c[i];
            ans = Math.max(ans, sum);
            sum -= c[i - K + 1];
        }

        System.out.println(ans);
    }
}