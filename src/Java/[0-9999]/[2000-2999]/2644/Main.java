import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] parent;
    static int n;

    static class P {
        int num;
        int chon;

        P(int num, int chon) {
            this.num = num;
            this.chon = chon;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        parent = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(parent[i], false);
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parent[a][b] = true;
            parent[b][a] = true;
        }

        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        Deque<P> q = new ArrayDeque<>();
        visited[x] = true;
        q.add(new P(x, 0));

        int ans = -1;

        while (!q.isEmpty()) {
            P curP = q.removeFirst();
            if (curP.num == y) {
                ans = curP.chon;
                break;
            }
            for (int i = 1; i < n + 1; i++) {
                if (!parent[curP.num][i]) continue;
                if (visited[i]) continue;
                visited[curP.num] = true;
                q.addLast(new P(i, curP.chon + 1));
            }
        }
        System.out.println(ans);
    }
}