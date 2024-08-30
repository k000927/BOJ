import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        int max_size = 0;
        int pic_num = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                if (paper[i][j] == 0) continue;

                pic_num++;
                ArrayList<Node> queue = new ArrayList<>();
                queue.add(new Node(i, j));
                visited[i][j] = true;

                int local_size = 1;
                while (!queue.isEmpty()) {
                    Node curNode = queue.remove(0);
                    int curX = curNode.x;
                    int curY = curNode.y;

                    for (int k = 0; k < 4; k++) {
                        int x = curX + dx[k];
                        int y = curY + dy[k];
                        if (x < 0 || x >= n || y < 0 || y >= m) continue;
                        if (visited[x][y]) continue;
                        if (paper[x][y] == 0) continue;

                        queue.add(new Node(x, y));
                        visited[x][y] = true;
                        local_size++;
                    }
                }

                max_size = Math.max(max_size, local_size);
            }
        }

        System.out.println(pic_num);
        System.out.println(max_size);
    }
}
