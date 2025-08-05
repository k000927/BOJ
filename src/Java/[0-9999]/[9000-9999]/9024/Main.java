import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int t, n, k;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);

            int s = 0, e = n - 1;
            int min = Integer.MAX_VALUE;
            int ans = 0;

            while (s < e) {
                int sum = num[s] + num[e];
                int gap = Math.abs(sum - k);
                if (min >= gap) {
                    if (min > gap) ans = 0;
                    min = gap;
                    ans++;
                }

                if (sum >= k)
                    e--;
                else
                    s++;
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
