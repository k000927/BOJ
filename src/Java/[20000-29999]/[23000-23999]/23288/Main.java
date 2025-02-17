import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static int[][] score;
    static boolean[][] visited;
    static Pos curPos = new Pos(0, 0);
    static int dir;
    static Dice dice;
    static int ans = 0;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Dice {
        int bottom;
        int front;
        int right;
        int left;
        int back;
        int top;

        Dice(int bottom, int front, int right, int left, int back, int top) {
            this.bottom = bottom;
            this.front = front;
            this.right = right;
            this.left = left;
            this.back = back;
            this.top = top;
        }

        void north() {
            int temp = front;
            front = top;
            top = back;
            back = bottom;
            bottom = temp;
        }

        void south() {
            int temp = top;
            top = front;
            front = bottom;
            bottom = back;
            back = temp;
        }

        void east() {
            int temp = left;
            left = bottom;
            bottom = right;
            right = top;
            top = temp;
        }

        void west() {
            int temp = right;
            right = bottom;
            bottom = left;
            left = top;
            top = temp;
        }
    }

    static void rollDice() {
        updateDir();

        switch (dir) {
            case 0:
                dice.east();
                break;
            case 1:
                dice.south();
                break;
            case 2:
                dice.west();
                break;
            case 3:
                dice.north();
        }

        curPos.x += dx[dir];
        curPos.y += dy[dir];

        ans += score[curPos.x][curPos.y];

        if (dice.bottom > map[curPos.x][curPos.y])
            dir = (dir + 1) % 4;
        else if (dice.bottom < map[curPos.x][curPos.y])
            dir = (dir + 3) % 4;
    }

    static void updateDir() {
        int nx = curPos.x + dx[dir];
        int ny = curPos.y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
            dir = (dir + 2) % 4;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setupScore();

        dice = new Dice(6, 2, 3, 4, 5, 1);

        for (int i = 0; i < k; i++) {
            rollDice();
        }

        System.out.println(ans);
    }

    static void bfs(int x, int y) {
        Deque<Pos> bfsDeque = new ArrayDeque<>();
        List<Pos> memoryList = new ArrayList<>();

        bfsDeque.add(new Pos(x, y));
        memoryList.add(new Pos(x, y));
        visited[x][y] = true;

        while (!bfsDeque.isEmpty()) {
            Pos cur = bfsDeque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny])
                    continue;

                if (map[cur.x][cur.y] != map[nx][ny])
                    continue;

                visited[nx][ny] = true;
                bfsDeque.add(new Pos(nx, ny));
                memoryList.add(new Pos(nx, ny));
            }
        }

        for (Pos pos : memoryList) {
            score[pos.x][pos.y] = memoryList.size() * map[pos.x][pos.y];
        }
    }

    static void setupScore() {
        score = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                bfs(i, j);
            }
        }
    }
}