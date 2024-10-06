import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static String[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Node[][] parent;
    static HashMap<String, Integer> dir;

    static class Node implements Comparable<Node> {
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

        @Override
        public int compareTo(Node o) {
            if (this.x != o.x) return this.x - o.x;
            else return this.y - o.y;
        }
    }

    static Node find(Node node) {
        int x = node.x;
        int y = node.y;
        if (parent[x][y] == node) return node;
        else return parent[x][y] = find(parent[x][y]);
    }

    static boolean union(Node node1, Node node2) {
        node1 = find(node1);
        node2 = find(node2);

        if (node1 == node2) return true;
        else parent[node2.x][node2.y] = node1;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dir = new HashMap<>();
        dir.put("U", 0);
        dir.put("D", 1);
        dir.put("L", 2);
        dir.put("R", 3);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        parent = new Node[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                parent[i][j] = new Node(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int iDir = dir.get(map[i][j]);
                Node srcNode = new Node(i, j);
                Node destNode = new Node(i + dx[iDir], j + dy[iDir]);

                if (union(srcNode, destNode)) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}