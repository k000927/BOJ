import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;

    static Queue<Planet> xPlanet;
    static Queue<Planet> yPlanet;
    static Queue<Planet> zPlanet;
    static Queue<Edge> edgeQueue;

    static int find(int x) {
        if (x == parent[x])
            return x;
        else {
            return parent[x] = find(parent[x]);
        }
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        } else {
            parent[y] = x;
            return false;
        }
    }

    static class Planet {
        int num, x, y, z;

        Planet(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, dist;

        Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.dist, e.dist);
        }
    }

    static Comparator<Planet> xComparator = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            return Integer.compare(o1.x, o2.x);
        }
    };

    static Comparator<Planet> yComparator = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            return Integer.compare(o1.y, o2.y);
        }
    };

    static Comparator<Planet> zComparator = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            return Integer.compare(o1.z, o2.z);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        xPlanet = new PriorityQueue<>(xComparator);
        yPlanet = new PriorityQueue<>(yComparator);
        zPlanet = new PriorityQueue<>(zComparator);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            Planet p = new Planet(i, x, y, z);
            xPlanet.add(p);
            yPlanet.add(p);
            zPlanet.add(p);

            parent[i] = i;
        }

        Planet prevX, prevY, prevZ, curX, curY, curZ;

        prevX = xPlanet.poll();
        prevY = yPlanet.poll();
        prevZ = zPlanet.poll();

        edgeQueue = new PriorityQueue<>();
        while (!xPlanet.isEmpty()) {
            curX = xPlanet.poll();
            curY = yPlanet.poll();
            curZ = zPlanet.poll();

            edgeQueue.add(new Edge(prevX.num, curX.num, Math.abs(curX.x - prevX.x)));
            edgeQueue.add(new Edge(prevY.num, curY.num, Math.abs(curY.y - prevY.y)));
            edgeQueue.add(new Edge(prevZ.num, curZ.num, Math.abs(curZ.z - prevZ.z)));

            prevX = curX;
            prevY = curY;
            prevZ = curZ;
        }

        int ans = 0, cnt = 0;

        while (cnt < N - 1) {
            Edge e = edgeQueue.poll();

            int from = e.from;
            int to = e.to;

            if (union(from, to)) {
                continue;
            }

            cnt++;
            ans += e.dist;
        }

        System.out.println(ans);
    }
}
