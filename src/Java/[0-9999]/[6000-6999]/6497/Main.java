import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[] parent;
    static Queue<Edge> queue;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        } else {
            parent[x] = y;
            return true;
        }
    }

    static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            parent = new int[m];
            queue = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int x, y, z, ans = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());
                ans += z;

                queue.add(new Edge(x, y, z));
            }

            Edge e;
            while (!queue.isEmpty()) {
                e = queue.poll();

                if(union(e.from, e.to))
                    ans -= e.weight;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
