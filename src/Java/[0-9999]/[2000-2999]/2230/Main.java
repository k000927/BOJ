import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N - 1; i++) {
            binarySearch(i, i + 1, N - 1);
        }
        System.out.println(min);
    }

    static void binarySearch(int i, int left, int right) {
        int j, d;

        while (left <= right) {
            j = (left + right) / 2;
            d = arr[j] - arr[i];
            if (d < M) {
                left = j + 1;
            } else if (d > min) {
                right = j - 1;
            } else {
                min = d;
                right = j - 1;
            }
        }
    }
}
