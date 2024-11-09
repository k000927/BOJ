import java.io.*;
import java.util.*;

public class Main {
    static int combo = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] game;
    static boolean[][] visited;

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean bfs(int x, int y, char color) {
        int puyo = 0;
        Queue<Pos> q = new LinkedList<>();
        Queue<Pos> puyoQ = new LinkedList<>();
        q.add(new Pos(x, y));
        puyoQ.add(new Pos(x, y));

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            puyo++;
            visited[pos.x][pos.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                if (visited[nx][ny]) continue;
                if (game[nx][ny] != color) continue;
                q.add(new Pos(nx, ny));
                puyoQ.add(new Pos(nx, ny));
            }
        }

        if (puyo >= 4) {
            for (Pos pos : puyoQ) {
                game[pos.x][pos.y] = '.';
            }
            return true;
        }
        return false;
    }

    static boolean boom() {
        int comboCount = 0;

        for (int i = 0; i < 12; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visited[i][j]) continue;
                if (game[i][j] == '.') continue;
                if (bfs(i, j, game[i][j])) comboCount++;
            }
        }

        return comboCount > 0;
    }

    static void gravity() {
        for (int j = 0; j < 6; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 11; i >= 0; i--) {
                if (game[i][j] == '.') continue;
                else {
                    sb.append(game[i][j]);
                    game[i][j] = '.';
                }
            }
            String line = sb.toString();
            for (int i = 0; i < line.length(); i++) {
                game[11 - i][j] = line.charAt(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        game = new char[12][6];
        visited = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                game[i][j] = line.charAt(j);
            }
        }

        while (boom()) {
            gravity();
            combo++;
        }

        System.out.println(combo);
    }
}