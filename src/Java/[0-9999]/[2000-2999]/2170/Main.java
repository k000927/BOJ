import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int ans = 0;
    static ArrayList<Draw> drawList;
    static StringTokenizer st;

    static class Draw implements Comparable<Draw> {
        int startPoint;
        int endPoint;

        Draw(int startPoint, int endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        @Override
        public int compareTo(Draw o) {
            if (this.startPoint < o.startPoint) return -1;
            else if (this.startPoint == o.startPoint) {
                if (this.endPoint < o.endPoint) return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        drawList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            drawList.add(new Draw(start, end));
        }

        Collections.sort(drawList);

        Draw prevDraw = drawList.get(0);
        Draw curDraw = null;

        ans += prevDraw.endPoint - prevDraw.startPoint;

        for (int i = 1; i < n; i++) {
            curDraw = drawList.get(i);

            if (curDraw.endPoint < prevDraw.endPoint) {
                continue;
            }

            if (curDraw.startPoint < prevDraw.endPoint) {
                curDraw.startPoint = prevDraw.endPoint;
            }

            ans += curDraw.endPoint - curDraw.startPoint;
            prevDraw = curDraw;
        }

        System.out.println(ans);
    }
}