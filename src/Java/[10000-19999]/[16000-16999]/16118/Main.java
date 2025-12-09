import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    static class Node implements Comparable<Node> {
        int n, d;
        boolean flag;

        public Node(int n, int d, boolean flag) {
            this.n = n;
            this.d = d;
            this.flag = flag;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    static int N, M, INF = 987654321;
    static List<List<Node>> map;
    static int[] dist1;
    static int[][] dist2;

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist1[1] = 0;
        pq.add(new Node(1, 0, true));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist1[cur.n] < cur.d) continue;
            for (int i = 0; i < map.get(cur.n).size(); i++) {
                Node nextNode = map.get(cur.n).get(i);
                int nextD = cur.d + nextNode.d;
                int nextN = nextNode.n;
                if (nextD < dist1[nextN]) {
                    dist1[nextN] = nextD;
                    pq.add(new Node(nextN, nextD, true));
                }
            }
        }

        dist2[1][1] = 0;
        pq.add(new Node(1, 0, true));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist2[cur.n][cur.flag ? 1 : 0] < cur.d) continue;
            for (int i = 0; i < map.get(cur.n).size(); i++) {
                Node nextNode = map.get(cur.n).get(i);
                int nextD = cur.d + (cur.flag ? nextNode.d / 2 : nextNode.d * 2);
                int nextN = nextNode.n;
                if (nextD < dist2[nextN][!cur.flag ? 1 : 0]) {
                    dist2[nextN][!cur.flag ? 1 : 0] = nextD;
                    pq.add(new Node(nextN, nextD, !cur.flag));
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        dist1 = new int[N + 1];
        dist2 = new int[N + 1][2];
        Arrays.fill(dist1, INF);

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
            Arrays.fill(dist2[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(a).add(new Node(b, c * 2, true));
            map.get(b).add(new Node(a, c * 2, true));
        }

        dijkstra();


        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (dist1[i] < Math.min(dist2[i][0], dist2[i][1]))
                result++;
        }
        System.out.println(result);
    }
}