import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static int ans = Integer.MAX_VALUE;
    static int[][] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        road = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(road[i], Integer.MAX_VALUE);
        }

        int from, to, weight;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            road[from][to] = weight;
        }


        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                if (road[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 1; j <= V; j++) {
                    if (road[k][j] == Integer.MAX_VALUE) continue;
                    road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (road[i][j] == Integer.MAX_VALUE || road[j][i] == Integer.MAX_VALUE) continue;
                ans = Math.min(ans, road[i][j] + road[j][i]);
            }
        }

        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}