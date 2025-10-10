import java.io.*;

public class Main {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        long res = N;
        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                res -= res / i;
                while (N % i == 0) N /= i;
            }
        }

        if (N > 1) res -= res / N;
        System.out.println(res);
    }
}