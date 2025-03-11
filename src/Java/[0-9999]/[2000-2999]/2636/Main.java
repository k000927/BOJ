import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 * meltingTime[][] -> 해당 위치가 공기라면 해당 공기가 외부 공기가 되는데 걸리는 시간을 나타낸다. 해당 위치가 치즈라면 녹는데 걸리는 시간을 나타낸다.
 * 					초기에는 Integer.MAX_VALUE로 초기화한다.
 * isCheese[][] -> 0이라면 공기, 1이라면 치즈를 의미한다.
 * 
 * 1. (0,0) 부터 BFS를 진행한다. Queue에 Pos 정보를 넣고 meltingTime[0][0] = 0으로 초기화한다.
 * 		1.1. 4방 탐색을 진행한다.
 * 		1.2. (nx, ny)가 범위를 벗어난다면 continue
 * 		1.3. meltingTime[x][y]+isCheese[x][y] > meltingTime[nx][ny]라면 continue
 		1.4. meltingTime[nx][ny] = meltingTime[x][y]+isCheese[x][y]로 업데이트 후 큐에 삽입
 */

public class Main {
    static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    // 치즈 판의 크기
    static int H;
    static int W;

    // 녹는데 걸리는 시간
    static int[][] meltingTime;

    // 치즈 여부
    static int[][] isCheese;

    // 위치 정보 클래스
    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        ;
    }

    // 커스텀 큐
    // 오버플로우, 언더플로우는 나지 않는다고 가정
    static class MyQueue {
        Pos[] queue;
        int head;
        int tail;

        MyQueue(int size) {
            queue = new Pos[size];
            head = 0;
            tail = 0;
        }

        public void clear() {
            head = 0;
            tail = 0;
        }

        public void push(Pos p) {
            queue[tail++] = p;
        }

        public Pos poll() {
            return queue[head++];
        }

        public boolean isEmpty() {
            return head == tail;
        }
    }

    // 델타 배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    // bfs를 이용해서 meltingTime 세팅
    static void setMeltingTime() {
        MyQueue queue = new MyQueue(H * W * 4);

        meltingTime[0][0] = 0;
        queue.push(new Pos(0, 0));

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];

                // OutOfBound
                if (nx < 0 || ny < 0 || nx == H || ny == W)
                    continue;

                // 유망하지 않은 경우 스킵
                if (meltingTime[nx][ny] <= meltingTime[curPos.x][curPos.y] + isCheese[nx][ny])
                    continue;

                // meltingTime 업데이트
                meltingTime[nx][ny] = meltingTime[curPos.x][curPos.y] + isCheese[nx][ny];
                queue.push(new Pos(nx, ny));
            }
        }
    }

    // 최댓값 구하기
    static void getMaxMeltingTime() {
        int maxMeltingTime = 0;
        int cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 현재 최댓값보다 작을 때 스킵
                if (maxMeltingTime > meltingTime[i][j])
                    continue;
                    // 현재 최댓값과 같고, 치즈 칸이라면 cnt++
                else if (maxMeltingTime == meltingTime[i][j]) {
                    if (isCheese[i][j] == 1)
                        cnt++;
                } else {
                    // 현재 최댓값보다 크다면 최댓값과 cnt 업데이트
                    maxMeltingTime = meltingTime[i][j];
                    cnt = 1;
                }
            }
        }

        System.out.println(maxMeltingTime + "\n" + cnt);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        H = nextInt();
        W = nextInt();

        meltingTime = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(meltingTime[i], Integer.MAX_VALUE);
        }

        isCheese = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                isCheese[i][j] = nextInt();
            }
        }

        setMeltingTime();

        getMaxMeltingTime();
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}