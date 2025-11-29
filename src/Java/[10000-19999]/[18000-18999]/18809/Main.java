import java.io.*;
import java.util.*;

public class Main {
    static int n, m, g, r;
    static int[][] map;
    static boolean[][] red_visited;
    static boolean[][] green_visited;
    static int ans = 0;
    static boolean[] dfs_visited;
    static int[][] red_time;
    static int[][] green_time;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] copy_map;
    static ArrayList<Node> dfs_list = new ArrayList<>();
    static ArrayList<Node> green = new ArrayList<>();
    static ArrayList<Node> red = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        g = Integer.parseInt(t[2]);
        r = Integer.parseInt(t[3]);

        map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String[] tt = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(tt[j - 1]);
                if (map[i][j] == 2) {
                    dfs_list.add(new Node(i, j));
                }
            }
        }
        dfs_visited = new boolean[dfs_list.size()];
        green_dfs(0, 0);
        System.out.println(ans);
    }

    public static void copy_map() {
        copy_map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            if (m >= 0) System.arraycopy(map[i], 1, copy_map[i], 1, m);
        }
    }

    public static void bfs() {
        int flower = 0;
        green_visited = new boolean[n + 1][m + 1];
        green_time = new int[n + 1][m + 1];
        red_visited = new boolean[n + 1][m + 1];
        red_time = new int[n + 1][m + 1];

        copy_map();
        Queue<Node> rq = new LinkedList<>();
        Queue<Node> gq = new LinkedList<>();

        for (Node node : red) {
            rq.add(node);
            red_visited[node.x][node.y] = true;
        }
        for (Node node : green) {
            green_visited[node.x][node.y] = true;
            gq.add(node);
        }


        while (!rq.isEmpty() && !gq.isEmpty()) {
            if (!gq.isEmpty()) {
                int rep = gq.size();
                while (rep-- != 0) {
                    Node a = gq.poll();
                    green_visited[a.x][a.y] = true;
                    if (copy_map[a.x][a.y] == 3) {
                        continue;
                    }

                    for (int i = 0; i < 4; i++) {
                        int nx = a.x + dx[i];
                        int ny = a.y + dy[i];
                        if (isRange(nx, ny) && (copy_map[nx][ny] == 1 || copy_map[nx][ny] == 2) && !green_visited[nx][ny]) {
                            green_visited[nx][ny] = true;
                            green_time[nx][ny] = green_time[a.x][a.y] + 1;
                            gq.add(new Node(nx, ny));
                        }
                    }
                }
            }
            if (!rq.isEmpty()) {
                int rep = rq.size();
                while (rep-- != 0) {
                    Node a = rq.poll();
                    red_visited[a.x][a.y] = true;

                    if (copy_map[a.x][a.y] == 3) {
                        continue;
                    }
                    for (int i = 0; i < 4; i++) {
                        int nx = a.x + dx[i];
                        int ny = a.y + dy[i];
                        if (isRange(nx, ny) && (copy_map[nx][ny] == 1 || copy_map[nx][ny] == 2) && !red_visited[nx][ny]) {
                            red_visited[nx][ny] = true;
                            red_time[nx][ny] = red_time[a.x][a.y] + 1;
                            if (red_time[nx][ny] == green_time[nx][ny]) {

                                flower++;
                                copy_map[nx][ny] = 3;
                            } else {
                                rq.add(new Node(nx, ny));
                            }
                        }
                    }
                }
            }
        }
        ans = Math.max(ans, flower);
    }

    public static void red_dfs(int level, int now) {
        if (level == r) {
            red.clear();
            for (int i = 0; i < dfs_list.size(); i++) {
                Node a = dfs_list.get(i);
                if (dfs_visited[i] && !green.contains(a)) {
                    red.add(a);
                }
            }
            bfs();
            return;
        }
        for (int i = now; i < dfs_list.size(); i++) {
            if (!dfs_visited[i]) {
                dfs_visited[i] = true;
                red_dfs(level + 1, i + 1);
                dfs_visited[i] = false;
            }
        }
    }

    public static void green_dfs(int level, int now) {
        if (level == g) {
            green.clear();
            for (int i = 0; i < dfs_list.size(); i++) {
                if (dfs_visited[i]) {
                    Node a = dfs_list.get(i);
                    green.add(a);
                }
            }
            red_dfs(0, 0);
            return;
        }
        for (int i = now; i < dfs_list.size(); i++) {
            if (!dfs_visited[i]) {
                dfs_visited[i] = true;
                green_dfs(level + 1, i + 1);
                dfs_visited[i] = false;
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= n && y <= m;
    }
}

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}