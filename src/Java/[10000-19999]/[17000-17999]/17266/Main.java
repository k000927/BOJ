import java.io.*;
import java.util.*;

public class Main {
    static int max = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Boolean[] x = new Boolean[n + 1];
        Arrays.fill(x, false);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            x[Integer.parseInt(st.nextToken())] = true;
        }

        int[] before = new int[n];
        int[] after = new int[n];
        Arrays.fill(before, max);
        Arrays.fill(after, max);
        if (x[0]) before[0] = 1;
        if (x[n]) after[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            if (x[i]) before[i] = 1;
            else before[i] = before[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (x[i]) after[i] = 0;
            else after[i] = after[i + 1] + 1;
        }

        int ans = -1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.min(after[i], before[i]));
        }

        System.out.println(ans);
    }
}