import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int ans;

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static void updateMap(int[][] newMap){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = newMap[i][j];
            }
        }
    }

    static void step3() {
        int[] pos = {N / 2, N / 2, 3};
        int[] newPos = {N / 2, N / 2, 3};
        boolean[][] visited = new boolean[N][N];
        boolean[][] newVisited = new boolean[N][N];
        visited[N / 2][N / 2] = true;
        newVisited[N / 2][N / 2] = true;

        int[][] newMap = new int[N][N];

        int seq = 0;
        int prev = map[N / 2][N / 2 - 1];
        while (getNextPos(pos, visited)) {
            int x = pos[0];
            int y = pos[1];
            if (prev == map[x][y]) {
                seq++;
            } else {
                if (!getNextPos(newPos, newVisited)) {
                    updateMap(newMap);
                    return;
                }
                newMap[newPos[0]][newPos[1]] = seq;
                if (!getNextPos(newPos, newVisited)) {
                    updateMap(newMap);
                    return;
                }
                newMap[newPos[0]][newPos[1]] = prev;

                seq = 1;
                prev = map[x][y];
            }
        }

        updateMap(newMap);
        compress();
        
    }

    static void blizzard(int d, int s) {
        step1(d, s);
        step2();
        step3();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            blizzard(d, s);
        }

        System.out.println(ans);
    }

    static int getNextDir(int dir) {
        if (dir == 1) return 3;
        if (dir == 2) return 4;
        if (dir == 3) return 2;
        if (dir == 4) return 1;
        return 0;
    }

    static boolean isOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    static void step1(int d, int s) {
        int x = N / 2;
        int y = N / 2;

        for (int i = 1; i <= s; i++) {
            x += dx[d];
            y += dy[d];

            map[x][y] = 0;
        }
        compress();
    }

    static boolean getNextPos(int[] pos, boolean[][] visited) {
        int nDir = getNextDir(pos[2]);
        int nx = pos[0] + dx[nDir];
        int ny = pos[1] + dy[nDir];

        if (isOutOfBounds(nx, ny))
            return false;

        if (pos[0] == N / 2 && pos[1] == N / 2 || visited[nx][ny]) {
            nx = pos[0] + dx[pos[2]];
            ny = pos[1] + dy[pos[2]];
            nDir = pos[2];
            if (isOutOfBounds(nx, ny))
                return false;
        }

        pos[0] = nx;
        pos[1] = ny;
        pos[2] = nDir;

        visited[pos[0]][pos[1]] = true;
        return true;
    }

    static void compress() {
        int[] pos = {N / 2, N / 2, 3};
        int[] newPos = {N / 2, N / 2, 3};
        boolean[][] visited = new boolean[N][N];
        boolean[][] newVisited = new boolean[N][N];
        visited[N / 2][N / 2] = true;
        newVisited[N / 2][N / 2] = true;

        while (getNextPos(pos, visited)) {
            if (map[pos[0]][pos[1]] == 0)
                continue;

            getNextPos(newPos, newVisited);
            map[newPos[0]][newPos[1]] = map[pos[0]][pos[1]];
        }

        while (getNextPos(newPos, newVisited)) {
            map[newPos[0]][newPos[1]] = 0;
        }
    }

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void step2() {
        int[] pos = {N / 2, N / 2, 3};
        boolean[][] visited = new boolean[N][N];
        visited[N / 2][N / 2] = true;
        Queue<Pos> posQueue = new LinkedList<>();

        boolean flag = false;

        int seq = 0;
        int prev = -1;
        while (getNextPos(pos, visited)) {
            int x = pos[0];
            int y = pos[1];
            if (prev == map[x][y]) {
                seq++;
                posQueue.add(new Pos(x, y));
            } else {
                if (seq >= 4) {
                    while (!posQueue.isEmpty()) {
                        Pos curPos = posQueue.poll();
                        ans += map[curPos.x][curPos.y];
                        map[curPos.x][curPos.y] = 0;
                    }
                    flag = true;
                }
                seq = 1;
                prev = map[x][y];
                posQueue.clear();
                posQueue.add(new Pos(x, y));
            }
        }
        compress();
        if (flag)
            step2();
    }
}
