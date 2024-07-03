import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] maxPassSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        maxPassSize = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int gap = a[0] - b[0];
        for (int i = 0; i < n; i++) {
            gap = Math.min(gap, a[i] - b[i]);
            maxPassSize[i] = gap;
        }

        int q = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int w = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (maxPassSize[mid] >= w) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(right+1);
        }
    }
}
// 9 6 5 5 3 3 1
