import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] A;
    static long[] B;
    static long[] C;
    static long[] D;

    static long findByTwoPointer() {
        long[] AB = new long[n * n];
        long[] CD = new long[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[i * n + j] = A[i] + B[j];
                CD[i * n + j] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long count = 0;

        int l = 0, r = n * n - 1;
        while (l < n * n && r >= 0) {
            long sum = AB[l] + CD[r];

            if (sum < 0) {
                l++;
                continue;
            }

            if (sum > 0) {
                r--;
                continue;
            }

            long lCount = 1;
            l++;
            while (l < n * n && AB[l] == AB[l - 1]) {
                lCount++;
                l++;
            }

            long rCount = 1;
            r--;
            while (r >= 0 && CD[r] == CD[r + 1]) {
                rCount++;
                r--;
            }

            count += lCount * rCount;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        A = new long[n];
        B = new long[n];
        C = new long[n];
        D = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(findByTwoPointer());
        br.close();
    }
}