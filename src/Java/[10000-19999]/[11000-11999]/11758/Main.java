import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int ccw(Point p1, Point p2, Point p3) {
        int ccw = (p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y);
        return Integer.compare(ccw, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        System.out.println(ccw(p1, p2, p3));
    }
}