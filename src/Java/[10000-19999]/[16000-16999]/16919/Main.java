import java.io.*;
import java.util.*;

public class Main {
    static char[][][] answer;
    static int R, C;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static Queue<Point> q;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        answer = new char[R][C][4];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int c = 1; c < 4; c++) {
                    answer[i][j][c] = 'O';
                }
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < C; j++) {
                answer[i][j][0] = s.charAt(j);
            }
        }

        for (int c = 0; c < 2; c++) {
            q = new LinkedList<>();
            for (int i = 0; i < answer.length; i++) {
                for (int j = 0; j < answer[i].length; j++) {
                    if (answer[i][j][c] == 'O') {
                        q.offer(new Point(i, j));
                    }
                }
            }
            bfs(c + 1);
        }

        if (N == 1) {
            print(answer, 0);
        } else if (N % 2 == 0) {
            print(answer, 3);
        } else if (N % 4 == 3) {
            print(answer, 1);
        } else if (N % 4 == 1) {
            print(answer, 2);
        }

    }

    private static void bfs(int c) {
        while (!q.isEmpty()) {
            Point p = q.poll();
            answer[p.x][p.y][c] = '.';
            for (int d = 0; d < dx.length; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && answer[nx][ny][c] == 'O') {
                    answer[nx][ny][c] = '.';
                }
            }
        }

    }

    private static void print(char[][][] answer, int idx) {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j][idx]);
            }
            System.out.println();
        }
    }
}