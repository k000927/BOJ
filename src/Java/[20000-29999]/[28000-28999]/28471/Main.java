import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1};

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[][] game = new String[n][n];
        Boolean[][] visited = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        Queue<Pos> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            game[i] = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (game[i][j].equals("F")) {
                    queue.add(new Pos(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();

            int x = curPos.x;
            int y = curPos.y;
            for (int i = 0; i < 7; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= n) continue;
                if (visited[next_x][next_y] || game[next_x][next_y].equals("#")) continue;

                queue.add(new Pos(next_x, next_y));
                visited[next_x][next_y] = true;
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.flush();
    }
}