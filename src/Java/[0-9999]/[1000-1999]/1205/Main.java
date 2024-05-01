import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int ans = 1;
        int same = 0;
        if (n == 0) {
            System.out.println(ans);
            return;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            if (s > score) ans++;
            if (s == score) same++;
        }
        if (same + ans > p) System.out.println(-1);
        else System.out.println(ans);
    }
}