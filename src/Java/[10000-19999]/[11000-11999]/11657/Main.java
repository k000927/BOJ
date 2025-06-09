import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static long[] dist;
    static List<Edge> edges;

    static class Edge {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static boolean bellmanFord(int start) {
        dist[start] = 0;

        int from, to, weight;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                from = edges.get(j).from;
                to = edges.get(j).to;
                weight = edges.get(j).weight;

                if (dist[from] != INF && dist[to] > dist[from] + weight) {
                    dist[to] = dist[from] + weight;
                    if (i == N - 1) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        dist = new long[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        if (bellmanFord(1)) System.out.println(-1);
        else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) ans.append(-1).append('\n');
                else ans.append(dist[i]).append('\n');
            }

            System.out.print(ans);
        }
    }
}
