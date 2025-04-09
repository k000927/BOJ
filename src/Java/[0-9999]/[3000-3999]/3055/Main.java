import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * bfs를 이용해서 물의 전파를 먼저 표시한다.
 *
 * 비버 이동을 bfs로 표현하고, 현재 시간과 물에 잠기는 시간을 비교해서 움직일 수 있는지 여부를 판단한다.
 */

public class Main {

    static int R;
    static int C;
    static char[][] map;

    // 물에 잠기는 시간
    static int[][] floodTimer;

    // 도착 위치
    static int denX;
    static int denY;

    // 시작 위치
    static int startX;
    static int startY;

    // 물의 개수와 위치
    static int waterNum;
    static int[] waterX;
    static int[] waterY;

    // 델타 배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void waterBFS() {
        int nx, ny, nt;
        while (!queue.isEmpty()) {
            queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = popX + dx[i];
                ny = popY + dy[i];
                nt = popT + 1;

                // OutOfBounds
                if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;

                // visited
                if (floodTimer[nx][ny] <= nt)
                    continue;

                // Rock or Den
                if (map[nx][ny] == 'D' || map[nx][ny] == 'X')
                    continue;

                queue.add(nx, ny, nt);
                floodTimer[nx][ny] = nt;
            }
        }
    }

    static String hedgehogBFS() {
        queue.clear();
        queue.add(startX, startY, 0);

        int nx, ny, nt;
        while (!queue.isEmpty()) {
            queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = popX + dx[i];
                ny = popY + dy[i];
                nt = popT + 1;

                // OutOfBounds
                if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;

                // flooded
                if (floodTimer[nx][ny] <= nt)
                    continue;

                // Rock
                if (map[nx][ny] == 'X')
                    continue;

                // Den
                if (map[nx][ny] == 'D')
                    return String.valueOf(nt);

                queue.add(nx, ny, nt);
                floodTimer[nx][ny] = nt;
            }
        }

        return "KAKTUS";
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[50][50];
        floodTimer = new int[50][50];
        waterX = new int[2500];
        waterY = new int[2500];

        String line;
        for (int i = 0; i < R; i++) {
            line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == '*') {
                    waterX[waterNum] = i;
                    waterY[waterNum++] = j;
                } else if (map[i][j] == 'D') {
                    denX = i;
                    denY = j;
                } else if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }

                floodTimer[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < waterNum; i++) {
            queue.add(waterX[i], waterY[i], 0);
            floodTimer[waterX[i]][waterY[i]] = 0;
        }
        waterBFS();
        System.out.println(hedgehogBFS());
    }

    static int popX;
    static int popY;
    static int popT;

    static MyQueue queue = new MyQueue();

    static class MyQueue {
        int[] xQueue;
        int[] yQueue;
        int[] tQueue;
        int head, tail;

        MyQueue() {
            xQueue = new int[2500];
            yQueue = new int[2500];
            tQueue = new int[2500];
            head = tail = 0;
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public void poll() {
            popX = xQueue[head];
            popY = yQueue[head];
            popT = tQueue[head++];
        }

        public void add(int x, int y, int t) {
            xQueue[tail] = x;
            yQueue[tail] = y;
            tQueue[tail++] = t;
        }

        public void clear() {
            head = tail = 0;
        }
    }
}
