import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] snack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        snack = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);

        int left = 1, right = snack[N - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (snack[i] >= mid) cnt += snack[i] / mid;
            }

            if (cnt >= M) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(right);
    }
}