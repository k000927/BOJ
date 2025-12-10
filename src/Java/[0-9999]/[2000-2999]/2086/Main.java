import java.io.*;
import java.util.*;

public class Main {
    static long a, b;
    static final long MOD = 1000000000;
    static Map<Long, Long> fiboMap;

    static long mulMod(long x, long y) {
        return (x % MOD) * (y % MOD) % MOD;
    }

    static long getFibonacci(long x) {
        if (fiboMap.containsKey(x))
            return fiboMap.get(x);

        long res = -1L;

        if ((x & 1) == 0) {
            long half = getFibonacci(x >> 1);
            long halfPlusOne = getFibonacci((x >> 1) + 1);

            long t = ((2 * halfPlusOne % MOD - half + MOD) % MOD);
            res = mulMod(half, t);
        } else {
            long p = getFibonacci((x + 1) >> 1);
            long m = getFibonacci((x - 1) >> 1);
            res = (mulMod(p, p) + mulMod(m, m)) % MOD;
        }


        if (res > MOD) res %= MOD;
        fiboMap.put(x, res);
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        fiboMap = new HashMap<>();

        fiboMap.put(0L, 0L);
        fiboMap.put(1L, 1L);
        fiboMap.put(2L, 1L);

        long ans = getFibonacci(b + 2) - getFibonacci(a + 1);
        if (ans < 0) ans += MOD;

        System.out.println(ans);
    }
}