import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int t;
    static int k;
    static int a;
    static int b;
    static boolean[][] live;
    static int[][] adj;

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void addLive(int x, int y) {
        int startX = Math.max(0, x - k);
        int startY = Math.max(0, y - k);
        int endX = Math.min(n - 1, x + k);
        int endY = Math.min(m - 1, y + k);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (x == i && y == j) continue;
                adj[i][j]++;
            }
        }

        live[x][y] = true;
    }

    public static void removeLive(int x, int y) {
        int startX = Math.max(0, x - k);
        int startY = Math.max(0, y - k);
        int endX = Math.min(n - 1, x + k);
        int endY = Math.min(m - 1, y + k);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (x == i && y == j) continue;
                adj[i][j]--;
            }
        }

        live[x][y] = false;
    }

    static void play() {
        ArrayList<Pos> addList = new ArrayList<>();
        ArrayList<Pos> removeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (live[i][j]) {
                    if (adj[i][j] >= a && adj[i][j] <= b) continue;
                    else removeList.add(new Pos(i, j));
                } else {
                    if (adj[i][j] > a && adj[i][j] <= b) addList.add(new Pos(i, j));
                }
            }
        }

        while (!addList.isEmpty()) {
            Pos curPos = addList.remove(0);
            addLive(curPos.x, curPos.y);
        }

        while (!removeList.isEmpty()) {
            Pos curPos = removeList.remove(0);
            removeLive(curPos.x, curPos.y);
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (live[i][j]) sb.append("*");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        live = new boolean[n][m];
        adj = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], 0);
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '*') {
                    live[i][j] = true;
                    addLive(i, j);
                }
            }
        }

        for (int i = 0; i < t; i++) {
            play();
        }

        print();
    }
}