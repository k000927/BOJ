import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    static int t;
    static int n;
    static int k;
    static int w;

    static int[] d;
    static int[] dp;
    static List<Integer>[] adj;
    static Building[] buildings;
    static Deque<Integer> queue;

    static class Building {
        int num;
        int inDegree;

        Building(int num, int inDegree) {
            this.num = num;
            this.inDegree = inDegree;
        }
    }

    static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        d = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        buildings = new Building[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
            buildings[i] = new Building(i, 0);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            buildings[b].inDegree++;
        }

        w = Integer.parseInt(br.readLine());

        queue = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (buildings[i].inDegree == 0) {
                queue.add(i);
                dp[i] = d[i];
            }
        }

        while (!queue.isEmpty()) {
            int curBuilding = queue.poll();

            for (Integer i : adj[curBuilding]) {
                buildings[i].inDegree--;
                dp[i] = Math.max(dp[i], dp[curBuilding] + d[i]);
                if (buildings[i].inDegree == 0) {
                    queue.add(i);
                }
            }
        }

        System.out.println(dp[w]);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solve();
        }
    }
}