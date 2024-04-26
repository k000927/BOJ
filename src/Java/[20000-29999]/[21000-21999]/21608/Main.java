import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int[][] classRoom;

    static class Student {
        int num;
        ArrayList<Integer> favorite = new ArrayList<>();

        Student(int num, int one, int two, int three, int four) {
            this.num = num;
            favorite.add(one);
            favorite.add(two);
            favorite.add(three);
            favorite.add(four);
        }
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static ArrayList<Position> func1(Student s) {
        int near_fav = -1;
        ArrayList<Position> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (classRoom[i][j] != 0) continue;
                int temp_near = 0;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || y < 0 || x >= n || y >= n) continue;
                    if (s.favorite.contains(classRoom[x][y])) {
                        temp_near++;
                    }
                }
                if (temp_near > near_fav) {
                    near_fav = temp_near;
                    temp.clear();
                    temp.add(new Position(i, j));
                } else if (temp_near == near_fav) {
                    temp.add(new Position(i, j));
                }
            }
        }
        return temp;
    }

    public static ArrayList<Position> func2(ArrayList<Position> arr) {
        int adj_empty = 0;
        ArrayList<Position> temp = new ArrayList<>();
        for (Position position : arr) {
            int temp_empty = 0;
            for (int i = 0; i < 4; i++) {
                int x = position.x + dx[i];
                int y = position.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                if (classRoom[x][y] == 0) temp_empty++;
            }
            if (temp_empty > adj_empty) {
                temp.clear();
                adj_empty = temp_empty;
                temp.add(new Position(position.x, position.y));
            } else if (temp_empty == adj_empty) {
                temp.add(new Position(position.x, position.y));
            }
        }
        return temp;
    }

    public static Position func3(ArrayList<Position> positions) {
        Position temp = positions.get(0);
        for (Position position : positions) {
            if (position.x < temp.x) {
                temp = position;
            } else if (position.x == temp.x) {
                if (position.y < temp.y) temp = position;
            }
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<Student> s = new ArrayList<>();
        ArrayList<Position> p = new ArrayList<>();
        classRoom = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(classRoom[i], 0);
        }
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int four = Integer.parseInt(st.nextToken());
            s.add(new Student(num, one, two, three, four));
        }

        for (int i = 0; i < n * n; i++) {
            ArrayList<Position> positions = func1(s.get(i));
            if (positions.size() == 1) {
                classRoom[positions.get(0).x][positions.get(0).y] = s.get(i).num;
                p.add(new Position(positions.get(0).x, positions.get(0).y));
                continue;
            }
            positions = func2(positions);
            if (positions.size() == 1) {
                classRoom[positions.get(0).x][positions.get(0).y] = s.get(i).num;
                p.add(new Position(positions.get(0).x, positions.get(0).y));

                continue;
            }
            Position po = func3(positions);
            classRoom[po.x][po.y] = s.get(i).num;
            p.add(new Position(po.x, po.y));
        }

        int ans = 0;

        for (int i = 0; i < n * n; i++) {
            Position curP = p.get(i);
            int temp = 0;
            for (int j = 0; j < 4; j++) {
                int x = curP.x + dx[j];
                int y = curP.y + dy[j];
                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                if (s.get(i).favorite.contains(classRoom[x][y])) temp++;
            }
            if (temp == 1) ans += 1;
            if (temp == 2) ans += 10;
            if (temp == 3) ans += 100;
            if (temp == 4) ans += 1000;
        }

        System.out.println(ans);
    }
}