import java.io.*;
import java.util.*;

public class Main {
    static int N, M, PR, PC;
    static final int U = 0, R = 1, D = 2, L = 3;
    static final char[] dir = {'U', 'R', 'D', 'L'};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;


    static int getNextDir(int curDir, int r, int c) {
        if (map[r][c] == '/') {
            if (curDir == U) return R;
            else if (curDir == R) return U;
            else if (curDir == D) return L;
            else return D;
        } else if (map[r][c] == '\\') {
            if (curDir == U) return L;
            else if (curDir == R) return D;
            else if (curDir == D) return R;
            else return U;
        }
        return curDir;
    }

    static int travel(int dir) {
        boolean[][][] visited = new boolean[N][M][4];

        int count = 1;
        int r = PR, c = PC;

        while (true) {
            if (visited[r][c][dir]) return -1;
            visited[r][c][dir] = true;

            dir = getNextDir(dir, r, c);

            r += dx[dir];
            c += dy[dir];

            if (r < 0 || c < 0 || r >= N || c >= M) return count;
            if (map[r][c] == 'C') return count;

            count++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        PR = Integer.parseInt(st.nextToken()) - 1;
        PC = Integer.parseInt(st.nextToken()) - 1;

        int ans = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int cur = travel(i);
            if (cur == -1) {
                sb = new StringBuilder();
                sb.append(dir[i]).append('\n').append("Voyager");
                break;
            } else if (cur > ans) {
                ans = cur;
                sb = new StringBuilder();
                sb.append(dir[i]).append('\n').append(cur);
            }
        }

        System.out.println(sb);
    }
}