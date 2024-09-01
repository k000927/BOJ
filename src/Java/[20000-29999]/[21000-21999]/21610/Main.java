import javax.print.attribute.standard.JobHoldUntil;
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] A;

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static Set<Node> cloud = new HashSet<>();
    static Set<Node> disappearedCloud;

    static void moveCloud(int d, int s) {
        for (Node node : cloud) {
            node.x = (node.x + dx[d] * s) % n;
            node.y = (node.y + dy[d] * s) % n;

            if (node.x < 0) node.x += n;
            if (node.y < 0) node.y += n;
        }
    }

    static void rain() {
        disappearedCloud = new HashSet<>();

        for (Node node : cloud) {
            A[node.x][node.y]++;
            disappearedCloud.add(node);
        }

        cloud = new HashSet<>();
    }

    static void waterCopyBug() {
        for (Node node : disappearedCloud) {
            for (int i = 1; i < 8; i+=2) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                if (A[x][y] > 0) A[node.x][node.y]++;
            }
        }
    }

    static void createCloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] >= 2 && !disappearedCloud.contains(new Node(i, j))) {
                    cloud.add(new Node(i, j));
                    A[i][j] -= 2;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud.add(new Node(n - 1, 0));
        cloud.add(new Node(n - 1, 1));
        cloud.add(new Node(n - 2, 0));
        cloud.add(new Node(n - 2, 1));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            // 구름 이동
            moveCloud(d, s);

            // 비 내림
            rain();

            // 물복사 버그
            waterCopyBug();

            // 구름 생성
            createCloud();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += A[i][j];
            }
        }

        System.out.println(ans);
    }
}