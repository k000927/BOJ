import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static Set<Node> visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Node {
        Pos red, blue;
        int count;

        Node(Pos red, Pos blue, int count) {
            this.red = red;
            this.blue = blue;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(red, node.red) && Objects.equals(blue, node.blue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(red, blue);
        }
    }

    // 0 -> 움직임 종료
    // 1 -> red 구멍
    // 2 -> blue 구멍
    static int move(Pos red, Pos blue, int dir) {
        boolean isRedInHole = false;
        while (true) {
            int nrx = -1, nry = -1, nbx = -1, nby = -1;
            if (!isRedInHole) {
                nrx = red.x + dx[dir];
                nry = red.y + dy[dir];
                if (map[nrx][nry] == 'O') {
                    isRedInHole = true;
                } else if (map[nrx][nry] == '#') {
                    nrx -= dx[dir];
                    nry -= dy[dir];
                }
            }

            nbx = blue.x + dx[dir];
            nby = blue.y + dy[dir];
            if (map[nbx][nby] == 'O')
                return 2;
            else if (map[nbx][nby] == '#') {
                nbx -= dx[dir];
                nby -= dy[dir];
            }


        }

        if (isRedInHole)
            return 1;
        else
            return 0;
    }

    static void print(Pos red, Pos blue) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (red.x == i && red.y == j) {
                    sb.append('R');
                } else if (blue.x == i && blue.y == j) {
                    sb.append('B');
                } else {
                    sb.append(map[i][j]);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new HashSet<>();
        map = new char[N][M];
        Pos red = null, blue = null;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if (c == 'B') {
                    blue = new Pos(i, j);
                    map[i][j] = '.';
                } else if (c == 'R') {
                    red = new Pos(i, j);
                    map[i][j] = '.';
                } else
                    map[i][j] = input.charAt(j);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(red, blue, 0);
        visited.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                Pos nr = new Pos(cur.red.x, cur.red.y);
                Pos nb = new Pos(cur.blue.x, cur.blue.y);

                int result = move(nr, nb, i);
                print(nr, nb);
                if (result == 0) {
                    Node next = new Node(nr, nb, cur.count + 1);
                    if (visited.contains(next))
                        continue;
                    visited.add(next);
                    queue.add(next);
                } else if (result == 1) {
                    System.out.println(cur.count + 1);
                    return;
                } else {
                    continue;
                }
            }
        }

        System.out.println(-1);
    }
}
