import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;

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
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int ans = 0;
    static int r;
    static int c;
    static int k;

    static void backTracking(ArrayList<Node> nodeList) {
        Node curNode = nodeList.get(nodeList.size() - 1);
        if (curNode.x == 0 && curNode.y == c - 1) {
            if (nodeList.size() == k) ans++;
            else return;
        }
        if (nodeList.size() > k) return;
        for (int i = 0; i < 4; i++) {
            int nextX = curNode.x + dx[i];
            int nextY = curNode.y + dy[i];
            if (nextX < 0 || nextX >= r || nextY < 0 || nextY >= c) continue;
            if (map[nextX][nextY].equals("T")) continue;
            if (nodeList.contains(new Node(nextX, nextY))) continue;
            nodeList.add(new Node(nextX, nextY));
            backTracking(nodeList);
            nodeList.remove(nodeList.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        for (int i = 0; i < r; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }

        ArrayList<Node> nodeList = new ArrayList<>();
        nodeList.add(new Node(r - 1, 0));
        backTracking(nodeList);

        System.out.println(ans);
    }
}
