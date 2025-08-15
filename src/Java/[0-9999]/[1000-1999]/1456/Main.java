import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long A, B;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        isPrime = new boolean[(int) Math.sqrt(B) + 1];
        Arrays.fill(isPrime, true);

        int count = 0;
        for (int i = 2; (long) i * i <= B; i++) {
            if (isPrime[i]) {
                for (long pow = (long) i * i; pow <= B; pow *= i) {
                    if (pow >= A) count++;
                    if (pow > B / i) break;
                }
                for (int j = 2; i * j <= Math.sqrt(B); j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        System.out.println(count);
    }
}
