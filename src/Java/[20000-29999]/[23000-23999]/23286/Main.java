import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int t;

    static int u;
    static int v;
    static int h;

    static int[][] ans;

    static void floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans[i][j] = Math.min(Math.max(ans[i][k], ans[k][j]), ans[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken()) - 1;
            v = Integer.parseInt(st.nextToken()) - 1;
            h = Integer.parseInt(st.nextToken());

            ans[u][v] = h;
        }

        floyd();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            if(ans[s][e] == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(ans[s][e]);
        }

    }
}