import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};

    static Pos js;
    static Set<Pos> arduinos;
    static Map<Pos, Integer> nextArduinos;

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int getDist(int x, int y) {
        return Math.abs(x - js.x) + Math.abs(y - js.y);
    }

    static boolean move(int op) {
        int nx = js.x + dx[op];
        int ny = js.y + dy[op];

        js.x = nx;
        js.y = ny;

        return arduinos.contains(js);
    }

    static boolean doArduino() {
        for (Pos arduino : arduinos) {
            int dir = 0;
            int minDist = Integer.MAX_VALUE;

            for (int i = 1; i <= 9; i++) {
                int nx = arduino.x + dx[i];
                int ny = arduino.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (minDist <= getDist(nx, ny)) continue;

                dir = i;
                minDist = getDist(nx, ny);
            }

            Pos nextArduino = new Pos(arduino.x + dx[dir], arduino.y + dy[dir]);
            nextArduinos.put(nextArduino, nextArduinos.containsKey(nextArduino) ? nextArduinos.get(nextArduino) + 1 : 1);
        }

        arduinos.clear();

        for (Pos arduino : nextArduinos.keySet()) {
            if (js.equals(arduino)) return true;

            int count = nextArduinos.get(arduino);
            if (count != 1) continue;

            arduinos.add(arduino);
        }

        nextArduinos.clear();

        return false;
    }

    static void print() {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                Pos p = new Pos(i, j);

                if (p.equals(js)) ans.append('I');
                else if (arduinos.contains(p)) ans.append('R');
                else ans.append('.');
            }
            ans.append('\n');
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arduinos = new HashSet<>();
        nextArduinos = new HashMap<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == 'I') js = new Pos(i, j);
                if (line.charAt(j) == 'R') arduinos.add(new Pos(i, j));
            }
        }

        String ops = br.readLine();
        for (int i = 0; i < ops.length(); i++) {
            int op = ops.charAt(i) - '0';

            if (move(op) || doArduino()) {
                System.out.printf("kraj %d\n", i + 1);
                System.exit(0);
            }
        }

        print();
    }
}