import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static Boolean[][] waste;
    static Boolean[][] visited;

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

    static int getWaste(int x, int y) {
        ArrayList<Node> nodeList = new ArrayList<>();

        int size = 0;
        nodeList.add(new Node(x, y));
        visited[x][y] = true;

        while (!nodeList.isEmpty()) {
            Node curNode = nodeList.remove(0);
            size++;

            for (int i = 0; i < 4; i++) {
                int nextX = curNode.x + dx[i];
                int nextY = curNode.y + dy[i];
                if (nextX >= n || nextX < 0 || nextY >= m || nextY < 0) continue;
                if (!waste[nextX][nextY]) continue;
                if (visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                nodeList.add(new Node(nextX, nextY));
            }
        }

        return size;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        waste = new Boolean[n][m];
        visited = new Boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(waste[i], false);
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            waste[x - 1][y - 1] = true;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!waste[i][j]) continue;
                if (visited[i][j]) continue;
                ans = Math.max(ans, getWaste(i, j));
            }
        }

        System.out.println(ans);
    }
}
