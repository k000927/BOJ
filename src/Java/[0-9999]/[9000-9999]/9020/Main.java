import java.io.*;
import java.util.*;

public class Main {
    static int T, n;
    static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 0; i <= 10000; i++) {
            if (!prime[i]) continue;
            for (int j = i * 2; j <= 10000; j += i) {
                prime[j] = false;
            }
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            for (int i = n / 2; i >= 2; i--) {
                if (prime[i] && prime[n - i]) {
                    sb.append(i).append(' ').append(n - i).append('\n');
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}