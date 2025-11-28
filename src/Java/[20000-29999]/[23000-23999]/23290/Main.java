import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, S, fishIndex;
    static Node[][][] map;
    static Map<Integer, Fish> fishMap;

    static int[] dx = {-99, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-99, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] sharkDir = {3, 1, 7, 5};

    static Pos shark;

    static void step2() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                Queue<Integer> fishQueue = map[0][i][j].fishQueue;
                for (Integer index : fishQueue) {
                    Fish fish = fishMap.get(index);
                    boolean flag = false;

                    for (int k = 0; k < 9; k++) {
                        int nDir = (fish.dir - k + 9) % 9;
                        int nx = i + dx[nDir];
                        int ny = j + dy[nDir];

                        // Out Of Bounds
                        if (nx < 1 || ny < 1 || nx > 4 || ny > 4)
                            continue;

                        // shark exists
                        if (nx == shark.x && ny == shark.y)
                            continue;

                        // Fish smell exists
                        if (map[0][nx][ny].smell > 0)
                            continue;

                        Fish nextFish = new Fish(fishIndex, nDir);
                        fishMap.put(fishIndex++, nextFish);
                        map[1][nx][ny].addFish(nextFish);
                        flag = true;
                        break;
                    }

                    if (!flag) {
                        map[1][i][j].addFish(fish);
                    }
                }
            }
        }
    }

    static int maxScore;
    static int[] maxPath;
    static boolean[][] visited;

    static void step3() {
        maxScore = -1;
        maxPath = new int[3];

        sharkMoving(0, new int[3]);

        for (int i = 0; i < 3; i++) {
            shark.x += dx[maxPath[i]];
            shark.y += dy[maxPath[i]];

            if (!map[1][shark.x][shark.y].fishQueue.isEmpty()) {
                map[1][shark.x][shark.y].fishQueue.clear();
                map[1][shark.x][shark.y].smell = 3;
            }
        }
    }

    static void step4() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (map[1][i][j].smell == 0)
                    continue;
                map[1][i][j].smell--;
            }
        }
    }

    static void step5() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                Queue<Integer> fishQueue = map[1][i][j].fishQueue;
                while (!fishQueue.isEmpty()) {
                    Fish fish = fishMap.get(fishQueue.poll());
                    map[0][i][j].addFish(fish);
                }
                map[0][i][j].smell = map[1][i][j].smell;
            }
        }
    }

    static void sharkMoving(int count, int[] path) {
        if (count == 3) {
            visited = new boolean[5][5];

            int x = shark.x;
            int y = shark.y;
            int score = 0;
            for (int i = 0; i < 3; i++) {
                x += dx[path[i]];
                y += dy[path[i]];

                // Out Of Bounds
                if (x < 1 || y < 1 || x > 4 || y > 4)
                    return;

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    score += map[1][x][y].fishQueue.size();
                }
            }

            if (score > maxScore) {
                maxScore = score;
                System.arraycopy(path, 0, maxPath, 0, 3);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                path[count] = sharkDir[i];
                sharkMoving(count + 1, path);
            }
        }
    }

    static void practice() {
        step2();
        step3();
        step4();
        step5();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new Node[2][5][5];
        fishMap = new HashMap<>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    map[i][j][k] = new Node();
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Fish fish = new Fish(fishIndex, d);
            fishMap.put(fishIndex++, fish);
            map[0][x][y].addFish(fish);
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        shark = new Pos(x, y);

        while (S-- > 0) {
            practice();
        }

        int count = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                count += map[0][i][j].fishQueue.size();
            }
        }

        System.out.println(count);
    }

    static class Node {
        int smell;
        Queue<Integer> fishQueue;

        Node() {
            this.smell = 0;
            this.fishQueue = new LinkedList<>();
        }

        void addFish(Fish fish) {
            fishQueue.add(fish.index);
        }
    }

    static class Fish {
        int index, dir;

        Fish(int index, int dir) {
            this.index = index;
            this.dir = dir;
        }
    }

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
