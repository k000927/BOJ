import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Star> constellation;
    static Set<Star> starSet;

    static class Star {
        int x, y;

        Star(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Star star = (Star) o;
            return x == star.x && y == star.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Star{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());

        constellation = new ArrayList<>();
        starSet = new HashSet<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            constellation.add(new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            starSet.add(new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int dx = 0, dy = 0;
        boolean flag;
        for (Star star : starSet) {
            flag = true;
            dx = star.x - constellation.get(0).x;
            dy = star.y - constellation.get(0).y;

            for (int i = 0; i < M; i++) {
                Star curStar = constellation.get(i);
                if (!starSet.contains(new Star(curStar.x + dx, curStar.y + dy))) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                break;
        }

        System.out.println(dx + " " + dy);

    }
}
