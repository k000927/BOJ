import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, T[i]);
        }


        long left = 0, right = (long) min * M;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (long i : T) {
                sum += (mid / i);
            }

            if (sum >= M)
                right = mid - 1;
            else
                left = mid + 1;
        }

        System.out.println(left);
    }
}