import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] parent;
    static int ans;
    static StringTokenizer st;
    static PriorityQueue<Edge> pq;

    static class Edge implements Comparable<Edge> {
        int v;
        int u;
        int weight;

        public Edge(int v, int u, int weight) {
            this.v = v;
            this.u = u;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(v, u, weight));
        }

        int max = -1;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (union(e.v, e.u)) {
                ans += e.weight;
                max = Math.max(max, e.weight);
            }
        }

        System.out.println(ans - max);
    }
}