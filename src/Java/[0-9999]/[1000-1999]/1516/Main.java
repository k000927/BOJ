import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    static StringTokenizer st;
    static ArrayList<Integer>[] adj;
    static Building[] buildings;
    static ArrayDeque<Integer> queue;

    static class Building {
        int inDegree;
        int time;

        Building(int inDegree, int time) {
            this.inDegree = inDegree;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        buildings = new Building[n];
        adj = new ArrayList[n];
        queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dp[i] = 0;
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            buildings[i] = new Building(0, time);

            int building;
            while ((building = Integer.parseInt(st.nextToken())) != -1) {
                buildings[i].inDegree++;
                adj[building - 1].add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (buildings[i].inDegree == 0) {
                queue.add(i);
                dp[i] = buildings[i].time;
            }
        }

        while (!queue.isEmpty()) {
            int curBuilding = queue.poll();

            for (Integer i : adj[curBuilding]) {
                dp[i] = Math.max(dp[i], dp[curBuilding] + buildings[i].time);
                buildings[i].inDegree--;
                if(buildings[i].inDegree == 0) queue.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[i]);
        }
    }
}