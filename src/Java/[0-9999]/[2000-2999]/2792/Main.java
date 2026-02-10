import java.io.*;
import java.util.*;

public class Main {
    static int[] jewelry;
    static int N, M, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        jewelry = new int[M];
        for (int i = 0; i < M; i++) {
            jewelry[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewelry[i]);
        }

        int min = Integer.MAX_VALUE;
        int left = 1, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int i : jewelry) {
                sum += i % mid == 0 ? i / mid : i / mid + 1;
            }

            if (N >= sum) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(min);
    }
}