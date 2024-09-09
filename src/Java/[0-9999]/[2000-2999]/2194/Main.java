import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int a;
    static int b;
    static int k;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] map;
    static boolean[][] visited;

    static class Node {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], false);
            Arrays.fill(visited[i], false);
        }

        int x;
        int y;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            for (int q = Math.max(x - a + 1, 0); q <= Math.min(x, n - 1); q++) {
                for (int r = Math.max(y - a + 1, 0); r <= Math.min(y, m - 1); r++) {
                    map[q][r] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == endX && node.y == endY) {
                System.out.println(node.cnt);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                if (newX + a - 1 >= n || newY + b - 1 >= m) continue;
                if (visited[newX][newY]) continue;
                if (map[newX][newY]) continue;
                visited[newX][newY] = true;
                queue.add(new Node(newX, newY, node.cnt + 1));
            }
        }

        System.out.println(-1);
    }
}