import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static char[][] game;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pos implements Cloneable {
        int x;
        int y;

        public Pos(int x, int y) {
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

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        protected Pos clone() throws CloneNotSupportedException {
            return (Pos) super.clone();
        }
    }

    static ArrayList<Pos> deepCopy(ArrayList<Pos> pos) throws CloneNotSupportedException {
        ArrayList<Pos> returnArray = new ArrayList<>();
        for (Pos po : pos) {
            returnArray.add(po.clone());
        }
        return returnArray;
    }

    static void backTracking(ArrayList<Pos> posList, int curValue, int x, int y, char op, int index) throws CloneNotSupportedException {
        if (index == m) {
            if (curValue == n) {
                System.out.println(1);
                for (Pos pos : posList) {
                    System.out.println(pos);
                }
                System.exit(0);
            } else return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
            if (posList.contains(new Pos(nx, ny))) continue;
            if (game[nx][ny] == '+' || game[nx][ny] == '-') {
                ArrayList<Pos> nextPosList = deepCopy(posList);
                nextPosList.add(new Pos(nx, ny));
                backTracking(nextPosList, curValue, nx, ny, game[nx][ny], index);
            } else {
                ArrayList<Pos> nextPosList = deepCopy(posList);
                nextPosList.add(new Pos(nx, ny));
                if (op == '+') backTracking(nextPosList, curValue + (game[nx][ny] - '0'), nx, ny, ' ', index + 1);
                else backTracking(nextPosList, curValue - (game[nx][ny] - '0'), nx, ny, ' ', index + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        game = new char[3][3];

        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            for (int j = 0; j < 3; j++) {
                game[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game[i][j] == '+' || game[i][j] == '-') continue;
                ArrayList<Pos> posList = new ArrayList<>();
                posList.add(new Pos(i, j));
                backTracking(posList, game[i][j] - '0', i, j, ' ', 1);
            }
        }
        System.out.println(0);
    }
}
