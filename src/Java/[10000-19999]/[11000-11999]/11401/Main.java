import java.io.*;
import java.util.*;

public class Main {
    static long N, K;
    static final long MOD = 1000000007L;

    static long factorial(long n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = (fact * i) % MOD;
        }
        return fact;
    }

    static long pow(long base, long exp) {
        if (exp == 0) return 1;
        else if (exp == 1) return base;

        long temp = pow(base, exp / 2);
        if (exp % 2 == 0) {
            return (temp % MOD * temp % MOD);
        } else {
            return ((temp % MOD * temp % MOD) % MOD * base) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(factorial(N) * pow((factorial(N - K) * factorial(K)) % MOD, MOD - 2) % MOD);
    }
}