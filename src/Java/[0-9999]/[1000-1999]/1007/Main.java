import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int n;
    static StringTokenizer st;
    static Pos[] posList;
    static ArrayList<Pos> addList;
    static ArrayList<Pos> subList;
    static double ans;

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void getVector() {
        long x = 0;
        long y = 0;
        for (Pos pos : addList) {
            x += pos.x;
            y += pos.y;
        }
        for (Pos pos : subList) {
            x -= pos.x;
            y -= pos.y;
        }
        double length = Math.sqrt(x * x + y * y);
        ans = Math.min(length, ans);
    }

    static void backTracking(int curIndex) {
        if (curIndex == n) getVector();
        if (addList.size() < n / 2) {
            addList.add(posList[curIndex]);
            backTracking(curIndex + 1);
            addList.remove(addList.size() - 1);
        }
        if (subList.size() < n / 2) {
            subList.add(posList[curIndex]);
            backTracking(curIndex + 1);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int curT = 0; curT < T; curT++) {

            n = Integer.parseInt(br.readLine());
            ans = Double.MAX_VALUE;
            posList = new Pos[n];
            addList = new ArrayList<>();
            subList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                posList[i] = new Pos(x, y);
            }

            backTracking(0);
            System.out.printf("%.7f\n", ans);
        }
    }
}