import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Pos> queue = new ArrayList<>();

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new Pos(0, 0));
        while (!queue.isEmpty()) {
            Pos cur = queue.remove(0);

            int count = map[cur.x][cur.y];

            int x = cur.x + count;
            int y = cur.y;

            if (x == N - 1 && y == N - 1) {
                System.out.println("HaruHaru");
                System.exit(0);
            }

            if(x < N && y <N && !visited[x][y]) {
                visited[x][y] = true;
                queue.add(new Pos(x, y));
            }

            x = cur.x;
            y = cur.y + count;

            if (x == N - 1 && y == N - 1) {
                System.out.println("HaruHaru");
                System.exit(0);
            }

            if(x < N && y <N && !visited[x][y]) {
                visited[x][y] = true;
                queue.add(new Pos(x, y));
            }
        }

        System.out.println("Hing");

    }
}