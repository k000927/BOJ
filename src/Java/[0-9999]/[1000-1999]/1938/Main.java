import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] map;
    // 0 -> 가로 방향일 때, 1 -> 세로 방향일 때
    static boolean[][][] visited;

    static Train train;
    static Train target;

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pos other = (Pos) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }

    static class Train {
        Pos pos;
        int state;
        int cnt;

        Train(Pos pos, int state, int cnt) {
            this.pos = pos;
            this.state = state;
            this.cnt = cnt;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((pos == null) ? 0 : pos.hashCode());
            result = prime * result + state;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Train other = (Train) obj;
            if (pos == null) {
                if (other.pos != null)
                    return false;
            } else if (!pos.equals(other.pos))
                return false;
            if (state != other.state)
                return false;
            return true;
        }
    }

    static Pos p1 = new Pos(0, 0);
    static Pos p2 = new Pos(0, 0);
    static Pos p3 = new Pos(0, 0);

    static boolean judge(int state) {
        if (p1.x < 0 || p1.x >= N || p2.x < 0 || p2.x >= N || p3.x < 0 || p3.x >= N)
            return false;

        if (p1.y < 0 || p1.y >= N || p2.y < 0 || p2.y >= N || p3.y < 0 || p3.y >= N)
            return false;

        if (map[p1.x][p1.y] == '1')
            return false;
        if (map[p2.x][p2.y] == '1')
            return false;
        if (map[p3.x][p3.y] == '1')
            return false;

        if (visited[state][p2.x][p2.y])
            return false;

        return true;
    }

    static boolean up(Train t) {
        // 가로일 때
        if (t.state == 0) {
            p1.x = p2.x = p3.x = t.pos.x + 1;
            p1.y = t.pos.y - 1;
            p2.y = t.pos.y;
            p3.y = t.pos.y + 1;
        } else {
            p1.y = p2.y = p3.y = t.pos.y;
            p1.x = t.pos.x + 2;
            p2.x = t.pos.x + 1;
            p3.x = t.pos.x;
        }

        return judge(t.state);
    }

    static boolean down(Train t) {
        // 가로일 때
        if (t.state == 0) {
            p1.x = p2.x = p3.x = t.pos.x - 1;
            p1.y = t.pos.y - 1;
            p2.y = t.pos.y;
            p3.y = t.pos.y + 1;
        } else {
            p1.y = p2.y = p3.y = t.pos.y;
            p1.x = t.pos.x - 2;
            p2.x = t.pos.x - 1;
            p3.x = t.pos.x;
        }

        return judge(t.state);
    }

    static boolean left(Train t) {
        // 가로일 때
        if (t.state == 0) {
            p1.x = p2.x = p3.x = t.pos.x;
            p1.y = t.pos.y - 2;
            p2.y = t.pos.y - 1;
            p3.y = t.pos.y;
        } else {
            p1.y = p2.y = p3.y = t.pos.y - 1;
            p1.x = t.pos.x - 1;
            p2.x = t.pos.x;
            p3.x = t.pos.x + 1;
        }

        return judge(t.state);
    }

    static boolean right(Train t) {
        // 가로일 때
        if (t.state == 0) {
            p1.x = p2.x = p3.x = t.pos.x;
            p1.y = t.pos.y;
            p2.y = t.pos.y + 1;
            p3.y = t.pos.y + 2;
        } else {
            p1.y = p2.y = p3.y = t.pos.y + 1;
            p1.x = t.pos.x - 1;
            p2.x = t.pos.x;
            p3.x = t.pos.x + 1;
        }

        return judge(t.state);
    }

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static boolean turn(Train t) {
        for (int i = 0; i < 8; i++) {
            int x = t.pos.x + dx[i];
            int y = t.pos.y + dy[i];

            if (x < 0 || x >= N || y < 0 || y >= N)
                return false;
            if (map[x][y] == '1')
                return false;
        }

        return !visited[(t.state + 1) % 2][t.pos.x][t.pos.y];
    }

    static int bfs() {
        Queue<Train> trainQueue = new ArrayDeque<>();
        trainQueue.add(train);
        visited[train.state][train.pos.x][train.pos.y] = true;

        while (!trainQueue.isEmpty()) {
            Train curTrain = trainQueue.poll();

            int state = curTrain.state;
            int x = curTrain.pos.x;
            int y = curTrain.pos.y;
            int curCnt = curTrain.cnt;

            if (curTrain.equals(target))
                return curCnt;

            if (up(curTrain)) {
                trainQueue.add(new Train(new Pos(x + 1, y), state, curCnt + 1));
                visited[state][x + 1][y] = true;
            }
            if (down(curTrain)) {
                trainQueue.add(new Train(new Pos(x - 1, y), state, curCnt + 1));
                visited[state][x - 1][y] = true;
            }
            if (left(curTrain)) {
                trainQueue.add(new Train(new Pos(x, y - 1), state, curCnt + 1));
                visited[state][x][y - 1] = true;
            }
            if (right(curTrain)) {
                trainQueue.add(new Train(new Pos(x, y + 1), state, curCnt + 1));
                visited[state][x][y + 1] = true;
            }
            if (turn(curTrain)) {
                trainQueue.add(new Train(new Pos(x, y), (state + 1) % 2, curCnt + 1));
                visited[(state + 1) % 2][x][y] = true;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[2][N][N];

        int[][] trainArr = new int[3][2];
        int[][] targetPos = new int[3][2];

        int trainIndex = 0;
        int targetIndex = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'B') {
                    trainArr[trainIndex][0] = i;
                    trainArr[trainIndex++][1] = j;
                }

                if (map[i][j] == 'E') {
                    targetPos[targetIndex][0] = i;
                    targetPos[targetIndex++][1] = j;
                }
            }
        }

        if (trainArr[0][0] == trainArr[1][0])
            train = new Train(new Pos(trainArr[1][0], trainArr[1][1]), 0, 0);
        else
            train = new Train(new Pos(trainArr[1][0], trainArr[1][1]), 1, 0);

        if (targetPos[0][0] == targetPos[1][0])
            target = new Train(new Pos(targetPos[1][0], targetPos[1][1]), 0, 0);
        else
            target = new Train(new Pos(targetPos[1][0], targetPos[1][1]), 1, 0);

        System.out.println(bfs());
    }
}
