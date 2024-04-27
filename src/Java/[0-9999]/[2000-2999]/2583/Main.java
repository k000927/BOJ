import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int K;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int num_of_area = 0;
    static PriorityQueue<Integer> answer = new PriorityQueue<>();

    static Boolean[][] board;
    static Boolean[][] visited;

    private static void getArea(int i, int j) {
        int temp_area = 0;
        Deque<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            temp_area++;
            for (int k = 0; k < 4; k++) {
                int x = curPos.x + dx[k];
                int y = curPos.y + dy[k];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (board[x][y]) continue;
                if (visited[x][y]) continue;
                queue.addLast(new Pos(x, y));
                visited[x][y] = true;
            }
        }
        answer.add(temp_area);
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new Boolean[N][M];
        visited = new Boolean[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], false);
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s_y = Integer.parseInt(st.nextToken());
            int s_x = Integer.parseInt(st.nextToken());
            int e_y = Integer.parseInt(st.nextToken());
            int e_x = Integer.parseInt(st.nextToken());
            for (int j = s_x; j < e_x; j++) {
                for (int k = s_y; k < e_y; k++) {
                    board[j][k] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] || visited[i][j]) continue;
                num_of_area++;
                getArea(i, j);
            }
        }

        System.out.println(num_of_area);
        while (!answer.isEmpty()) {
            System.out.print(answer.remove() + " ");
        }
        System.out.println();
    }
}