import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int T;
    static int[] s;
    static int[] r;
    static int[] num;
    static StringTokenizer st;
    static StringBuilder ans = new StringBuilder();

    static void solve() {
        for (int rIndex = n; rIndex >= 1; rIndex--) {
            int temp = 0;
            for (int numIndex = 1; numIndex <= n; numIndex++) {
                if (num[numIndex] == r[rIndex]) {
                    if (temp != 0) {
                        ans.append("IMPOSSIBLE\n");
                        return;
                    }
                    temp = numIndex;
                }
            }

            if (temp == 0) {
                ans.append("IMPOSSIBLE\n");
                return;
            }

            s[rIndex] = temp;
            num[temp] = -1;
            for (int i = temp + 1; i <= n; i++) {
                num[i]--;
            }
        }

        for (int i = 1; i <= n; i++) {
            ans.append(s[i]).append(" ");
        }

        ans.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            n = Integer.parseInt(br.readLine());

            s = new int[n + 1];
            r = new int[n + 1];
            num = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                r[i] = Integer.parseInt(st.nextToken());
                num[i] = i - 1;
            }

            solve();
        }
        System.out.println(ans);
    }
}