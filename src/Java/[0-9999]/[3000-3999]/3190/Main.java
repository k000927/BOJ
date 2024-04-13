import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][n + 1]; // 0 빈 공간, 1 사과, 2: 뱀
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        String[] move = new String[10001];
        Arrays.fill(move, "X");
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            move[x] = c;
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int size = 1;
        int dir = 0;
        int time = 0;
        board[1][1] = 2;
        Deque<Point> snake = new ArrayDeque<>();
        snake.addFirst(new Point(1, 1));
        while (true) {
            time++;

            //머리 늘리기
            Point curHead = snake.getFirst();
            int nextX = curHead.x + dx[dir % 4];
            int nextY = curHead.y + dy[dir % 4];
            if (nextX == 0 || nextY == 0 || nextX == n + 1 || nextY == n + 1) {
                break;
            }
            if (board[nextX][nextY] == 2) {
                break;
            }
            snake.addFirst(new Point(nextX, nextY));

            if (board[nextX][nextY] == 1) {
                board[nextX][nextY] = 0;
            } else {
                Point tail = snake.removeLast();
                board[tail.x][tail.y] = 0;
            }
            board[nextX][nextY] = 2;

            if (move[time].equals("L")) {
                if (dir == 0) {
                    dir = 3;
                } else {
                    dir--;
                }
            } else if (move[time].equals("D")) {
                dir++;
            }
        }

        System.out.println(time);

    }
}