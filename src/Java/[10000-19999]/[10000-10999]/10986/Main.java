import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static long[] mod;
    static long[] num;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;

        num = new long[n];
        mod = new long[m];

        st = new StringTokenizer(br.readLine());
        num[0] = Long.parseLong(st.nextToken()) % m;
        mod[(int) num[0]]++;
        if(num[0] == 0) ans++;
        for (int i = 1; i < n; i++) {
            num[i] = (num[i - 1] + Integer.parseInt(st.nextToken())) % m;
            if (num[i] == 0) {
                mod[(int) num[i]]++;
                ans += mod[0];
            }
            else {
                ans += mod[(int) num[i]];
                mod[(int) num[i]]++;
            }
        }

        System.out.println(ans);
    }
}