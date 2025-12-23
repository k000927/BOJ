import java.io.*;
import java.util.*;

public class Main {
    static int N, M, left, right;
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
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1, sum = 0;

            for (int i : arr) {
                sum += i;
                if (sum > mid) {
                    count++;
                    sum = i;
                }
            }

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left).append('\n');

        int sum = 0, count = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > left) {
                M--;
                sum = arr[i];
                ans.append(count).append(' ');
                count = 1;
            } else {
                count++;
            }

            if (M == N - i) break;
        }

        while (M-- > 0) {
            ans.append(count).append(' ');
            count = 1;
        }
        System.out.println(ans);
    }
}