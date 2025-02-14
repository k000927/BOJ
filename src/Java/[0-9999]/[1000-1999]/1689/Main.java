import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point> {
        int pos;
        boolean flag;

        Point(int pos, boolean flag) {
            this.pos = pos;
            this.flag = flag;
        }

        @Override
        public int compareTo(Point o) {
            if (pos == o.pos) {
                if (!flag) return -1;
                else if (!o.flag) return 1;
                else return 0;
            }
            return Integer.compare(pos, o.pos);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int up = Integer.parseInt(st.nextToken());
            int down = Integer.parseInt(st.nextToken());

            points.add(new Point(up, true));
            points.add(new Point(down, false));
        }

        Collections.sort(points);

        int ans = 0;
        int curSize = 0;

        for (Point point : points) {
            if (point.flag) {
                curSize++;
                ans = Math.max(ans, curSize);
            } else {
                curSize--;
            }
        }

        System.out.println(ans);
    }
}