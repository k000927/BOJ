import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Pos> posList = new ArrayList<>();

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) posList.add(new Pos(i, j));
            }
        }

        Pos one = posList.get(0);
        Pos two = posList.get(1);
        System.out.println(Math.abs(one.x - two.x) + Math.abs(one.y - two.y));
    }
}