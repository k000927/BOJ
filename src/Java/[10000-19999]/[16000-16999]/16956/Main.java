import java.io.*;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void update(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                continue;

            if (map[nx][ny] == 'W') {
                System.out.println(0);
                System.exit(0);
            }

            if (map[nx][ny] == 'S')
                continue;

            map[nx][ny] = 'D';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S')
                    update(i, j);
            }
        }

        System.out.println(1);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans.append(map[i][j]);
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}