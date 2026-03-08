import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static Pos destPos = new Pos(10000, 10000);
    static Pos[] posList;

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static long getDistSq(Pos p1, Pos p2) {
        long dx = (long) p1.x - p2.x;
        long dy = (long) p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    static boolean canReach(int maxFuel) {
        long fuelDistSq = 1L * maxFuel * 10 * maxFuel * 10;

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.offer(new int[] {0, 0}); // {현재 위치 인덱스, 지금까지 경유 횟수}
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int count = cur[1];

            Pos curPos = posList[idx];

            // 현재 위치에서 목적지로 바로 갈 수 있으면 성공
            if (getDistSq(curPos, destPos) <= fuelDistSq) {
                return true;
            }

            // 더 이상 경유할 수 없으면 다음 탐색 안 함
            if (count == K) continue;

            // 갈 수 있는 다음 비행장 탐색
            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;

                if (getDistSq(curPos, posList[i]) <= fuelDistSq) {
                    visited[i] = true;
                    q.offer(new int[] {i, count + 1});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        posList = new Pos[N + 1];
        posList[0] = new Pos(0, 0);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            posList[i] = new Pos(x, y);
        }

        int left = 0;
        int right = 1500; // 충분한 상한

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canReach(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}