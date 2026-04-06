import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C, D, co;
    static boolean[] isPrime;
    static Set<Integer> ytPrime, yjPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= 1000; i++) {
            if (!isPrime[i]) continue;
            for (int j = i << 1; j <= 1000; j += i) {
                isPrime[j] = false;
            }
        }

        ytPrime = new HashSet<>();
        yjPrime = new HashSet<>();

        for (int i = A; i <= B; i++) {
            if (isPrime[i]) ytPrime.add(i);
        }

        for (int i = C; i <= D; i++) {
            if (isPrime[i]) {
                if (ytPrime.contains(i)) {
                    co++;
                }
                yjPrime.add(i);
            }
        }

        System.out.println((ytPrime.size() - (co >> 1)) > (yjPrime.size() - (co - (co >> 1))) ? "yt" : "yj");
    }
}