import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int m;
    static int k;
    static int[] candy;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static ArrayList<Kids> kids = new ArrayList<>();
    static int[][] dp;

    static class Kids {
        int num;
        int candy;

        Kids(int num, int candy) {
            this.num = num;
            this.candy = candy;
        }
    }

    static void bfs(int x) {
        ArrayList<Integer> queue = new ArrayList<>();

        queue.add(x);
        visited[x] = true;
        Kids k = new Kids(1, candy[x]);

        while (!queue.isEmpty()) {
            Integer cur = queue.remove(0);

            for (Integer adjKid : adj[cur]) {
                if (visited[adjKid]) continue;
                k.num++;
                k.candy += candy[adjKid];
                queue.add(adjKid);
                visited[adjKid] = true;
            }
        }

        kids.add(k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        candy = new int[n + 1];
        visited = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
            visited[i] = false;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) continue;
            else bfs(i);
        }

        dp = new int[kids.size() + 1][k]; // 캔디, 우는 애들 수

        for (int i = 0; i < kids.size() + 1; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (kids.get(i - 1).num <= j) {
                    dp[i][j] = Math.max(kids.get(i - 1).candy + dp[i - 1][j - kids.get(i - 1).num], dp[i - 1][j]);
                } else dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[kids.size()][k - 1]);
    }
}