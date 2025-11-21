import java.io.*;
import java.util.*;

public class Main {
    static int r, c, n;
    static String[][] map;
    static boolean[][] visited;
    static int[] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int debug = 1;
    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");

        r = Integer.parseInt(t[0]);
        c = Integer.parseInt(t[1]);

        map = new String[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            String[] map_input = br.readLine().split("");
            if (c >= 0) System.arraycopy(map_input, 0, map[i], 1, c);
        }

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        String[] tt = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tt[i]);
        }

        for (int i = 0; i < n; i++) {
            int num = r - arr[i] + 1;

            solve(num, i % 2 == 0);
        }
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    public static void solve(int num, boolean flag) {
        visited = new boolean[r + 1][c + 1];
        if (flag) {
            for (int i = 1; i <= c; i++) {
                if (map[num][i].equals("x")) {
                    map[num][i] = ".";
                    break;
                }
            }
            bfs();
        } else {
            for (int i = c; i >= 1; i--) {
                if (map[num][i].equals("x")) {
                    map[num][i] = ".";

                    break;
                }
            }
            bfs();
        }
        get_cluster();
        move();
    }

    public static void move() {
        int cnt = 0;
        boolean flag = true;
        for (Node a : list) {
            map[a.x][a.y] = ".";
        }

        while (true) {
            if (list.isEmpty()) {
                break;
            }
            cnt++;
            for (Node cluster : list) {
                int x = cluster.x;
                int y = cluster.y;
                if (map[x + cnt][y].equals("x")) {
                    cnt--;
                    flag = false;
                    break;
                }

                if (x + cnt == r) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        for (Node a : list) {
            a.x += cnt;
            map[a.x][a.y] = "x";
        }
    }

    public static void get_cluster() {
        list.clear();
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (!visited[i][j] && map[i][j].equals("x")) {
                    list.add(new Node(i, j));
                }
            }
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 1; i <= c; i++) {
            if (map[r][i].equals("x")) {
                q.add(new Node(r, i));
                visited[r][i] = true;
            }
        }
        while (!q.isEmpty()) {
            Node a = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if (isRange(nx, ny) && !visited[nx][ny] && map[nx][ny].equals("x")) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= r && y <= c;
    }
}

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}