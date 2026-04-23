import java.io.*;
import java.util.*;

public class Main {
    static int R, C, HR, HC;
    static char[][] map;
    static boolean[][] wardMap;
    static char[][] ans;
    static int[] dx = {-1, 0, 1, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0};

    static Map<Character, Integer> dirMap = Map.of('U', 0, 'R', 1, 'D', 2, 'L', 3);

    static void wardBfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            ans[cur[0]][cur[1]] = '.';

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || ans[nx][ny] == '.' || map[nx][ny] != map[x][y]) continue;

                queue.add(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        wardMap = new boolean[R][C];
        ans = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                ans[i][j] = '#';
            }
        }

        st = new StringTokenizer(br.readLine());
        HR = Integer.parseInt(st.nextToken()) - 1;
        HC = Integer.parseInt(st.nextToken()) - 1;

        String ops = br.readLine();
        for (int i = 0; i < ops.length(); i++) {
            char op = ops.charAt(i);

            if (op == 'W') wardMap[HR][HC] = true;
            else {
                HR += dx[dirMap.get(op)];
                HC += dy[dirMap.get(op)];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (wardMap[i][j]) wardBfs(i, j);
            }
        }

        for (int i = 0; i < 5; i++) {
            int adjX = HR + dx[i];
            int adjY = HC + dy[i];

            if (adjX < 0 || adjX >= R || adjY < 0 || adjY >= C) continue;
            ans[adjX][adjY] = '.';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(ans[i]).append('\n');
        }

        System.out.print(sb);
    }
}