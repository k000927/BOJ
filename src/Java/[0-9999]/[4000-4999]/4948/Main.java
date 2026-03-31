import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static boolean[] prime;
    static int[] primeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        prime = new boolean[123456 * 2 + 1];
        primeCount = new int[123456 * 2 + 1];

        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        prime[2] = true;

        for (int i = 2; i <= 123456 * 2; i++) {
            if (!prime[i]) continue;
            for (int j = i << 1; j <= 123456 * 2; j += i) {
                prime[j] = false;
            }
        }

        for (int i = 1; i <= 123456 * 2; i++) {
            primeCount[i] += primeCount[i - 1] + (prime[i] ? 1 : 0);
        }

        StringBuilder ans = new StringBuilder();
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            ans.append(primeCount[N << 1] - primeCount[N]).append('\n');
        }

        System.out.print(ans);
    }
}