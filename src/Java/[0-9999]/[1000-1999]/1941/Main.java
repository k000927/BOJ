import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int count = 0;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Pos[] princess = new Pos[7];

    static boolean[][] princessMap = new boolean[5][5];
    static boolean[][] visited;

    static void check() {
        for (int i = 0; i < 7; i++) {
            princessMap[princess[i].x][princess[i].y] = true;
        }

        visited = new boolean[5][5];
        int adj = 1;
        visited[princess[0].x][princess[0].y] = true;
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(princess[0].x, princess[0].y));

        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            int x = p.x;
            int y = p.y;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (!princessMap[nx][ny]) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                adj++;
                queue.add(new Pos(nx, ny));
            }
        }

        if (adj == 7)
            count++;

        for (int i = 0; i < 7; i++) {
            princessMap[princess[i].x][princess[i].y] = false;
        }
    }

    static void comb(int sCnt, int yCnt, int index) {
        if (yCnt == 4)
            return;

        if (sCnt + yCnt == 7) {
            check();
            return;
        }

        if (index == 25)
            return;

        int x = index / 5;
        int y = index % 5;

        if (map[x][y] == 'S') {
            princess[sCnt + yCnt] = new Pos(x, y);
            comb(sCnt + 1, yCnt, index + 1);
        } else {
            princess[sCnt + yCnt] = new Pos(x, y);
            comb(sCnt, yCnt + 1, index + 1);
        }

        comb(sCnt, yCnt, index + 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        comb(0, 0, 0);

        System.out.println(count);
    }
}