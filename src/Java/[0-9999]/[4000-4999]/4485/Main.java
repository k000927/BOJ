import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 1;
        int idx = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int[][] cave = new int[n][n];
            int[][] min_dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    min_dist[i][j] = Integer.MAX_VALUE;
                }
            }

            min_dist[0][0] = cave[0][0];

            ArrayList<Node> queue = new ArrayList<>();
            queue.add(new Node(0, 0));

            while (!queue.isEmpty()) {
                Node curNode = queue.remove(0);
                for (int i = 0; i < 4; i++) {
                    int x = curNode.x + dx[i];
                    int y = curNode.y + dy[i];

                    if (x < 0 || x >= n || y < 0 || y >= n) continue;
                    if (min_dist[x][y] <= min_dist[curNode.x][curNode.y] + cave[x][y]) continue;
                    min_dist[x][y] = min_dist[curNode.x][curNode.y] + cave[x][y];
                    queue.add(new Node(x, y));
                }
            }


            bw.write("Problem " + idx++ + ": " + min_dist[n - 1][n - 1] + '\n');
        }
        bw.flush();
    }
}