import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w;
    static int h;
    static Character[][] map;
    static Boolean[][] visited;
    static Queue<Integer> ans;
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, 1, 0, -1, 0};

    static int idx = 0;
    static int temp;
    static Queue<Node> queue;

    static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    static void parseDot(int i, int j) {
        temp++;
        Queue<Node> dotQueue = new ArrayDeque<>();
        dotQueue.add(new Node(i, j));

        while (!dotQueue.isEmpty()) {
            Node curNode = dotQueue.poll();

            for (int k = 0; k < 5; k++) {
                int nextX = curNode.x + dx[k];
                int nextY = curNode.y + dy[k];

                if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue;
                if (visited[nextX][nextY]) continue;
                if (!map[nextX][nextY].equals('X')) {
                    queue.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                } else {
                    dotQueue.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    static void parseDice(int i, int j) {
        temp = 0;
        queue = new ArrayDeque<>();
        queue.add(new Node(i, j));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            for (int k = 0; k < 5; k++) {
                int nextX = curNode.x + dx[k];
                int nextY = curNode.y + dy[k];

                if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue;
                if (visited[nextX][nextY]) continue;
                if (map[nextX][nextY].equals('.')) continue;

                if (map[nextX][nextY].equals('X')) parseDot(nextX, nextY);

                queue.add(new Node(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }

        ans.add(temp);
    }

    static void parseImage() throws IOException {
        System.out.println("Throw " + idx);

        ans = new PriorityQueue<>();
        map = new Character[h][w];
        visited = new Boolean[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
            }
        }


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j]) continue;
                if (map[i][j].equals('.')) {
                    visited[i][j] = true;
                } else parseDice(i, j);
            }
        }

        while (!ans.isEmpty()) {
            System.out.print(ans.poll() + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            idx++;
            parseImage();
        }
    }
}