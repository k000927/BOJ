import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, n, m, t, s, g, h, a, b, d;
    static List<List<Edge>> adj;
    static int[] dist;
    static Queue<Integer> queue, ans;
    static StringBuilder sb;
    static Set<Integer> option;
    static boolean[] isContains;

    static void dijkstra() {

        queue.add(s);
        int from, to, weight;
        while (!queue.isEmpty()) {
            from = queue.poll();

            if (option.contains(from) && isContains[from]) {
                option.remove(from);
                ans.add(from);
            }

            for (Edge edge : adj.get(from)) {
                to = edge.to;
                weight = edge.weight;

                if (dist[to] > dist[from] + weight) {
                    dist[to] = dist[from] + weight;
                    if ((from == g && to == h) || (from == h && to == g) || isContains[from])
                        isContains[to] = true;
                    queue.add(to);
                }
            }
        }
    }

    static void print() {
        while (!ans.isEmpty()) {
            sb.append(ans.poll()).append(' ');
        }
        sb.append('\n');
    }


    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                adj.get(a).add(new Edge(b, d));
                adj.get(b).add(new Edge(a, d));
            }

            option = new HashSet<>();
            for (int i = 0; i < t; i++) {
                option.add(Integer.parseInt(br.readLine()));
            }

            queue = new PriorityQueue<>();
            ans = new PriorityQueue<>();

            dijkstra();
            print();
        }

        System.out.println(sb);
    }
}
