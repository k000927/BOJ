import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 10000;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, val;
            int cnt = 1;
            for (int i : arr) {
                min = Math.min(min, i);
                max = Math.max(max, i);

                val = max - min;
                if (val > mid) {
                    cnt++;
                    min = i;
                    max = i;
                }
            }

            if (cnt <= M)
                right = mid;
            else
                left = mid + 1;
        }

        System.out.println(left);
    }
}