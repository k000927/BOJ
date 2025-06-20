import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int L, R, C;
    static int[][][] building;
    static int[][][] visited;
    static Queue<Node> queue;

    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, 1, -1, 0, 0};
    static int[] dl = {0, 0, 0, 0, 1, -1};

    static class Node {
        int L, R, C;

        Node(int l, int r, int c) {
            this.L = l;
            this.R = r;
            this.C = c;
        }
    }

    static boolean init() throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if (L == 0 && R == 0 && C == 0) {
            return false;
        }

        building = new int[L][R][C];
        visited = new int[L][R][C];
        queue = new LinkedList<>();

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String line = br.readLine();
                for (int k = 0; k < C; k++) {
                    building[i][j][k] = line.charAt(k);
                    if (building[i][j][k] == 'S') {
                        queue.add(new Node(i, j, k));
                        visited[i][j][k] = 1;
                    }
                }
            }
            br.readLine();
        }

        return true;
    }

    static void solve() {
        while (!queue.isEmpty()) {
            Node n = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nl = n.L + dl[i];
                int nr = n.R + dr[i];
                int nc = n.C + dc[i];

                // Out Of Bounds
                if (nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                // Already visited
                if (visited[nl][nr][nc] != 0) continue;

                // Cannot move to that position
                if (building[nl][nr][nc] == '#') continue;


                // Arrived at the End
                if (building[nl][nr][nc] == 'E') {
                    ans.append("Escaped in ").append(visited[n.L][n.R][n.C]).append(" minute(s).").append("\n");
                    return;
                }

                visited[nl][nr][nc] = visited[n.L][n.R][n.C] + 1;
                queue.add(new Node(nl, nr, nc));
            }
        }

        ans.append("Trapped!").append("\n");
    }

    public static void main(String[] args) throws IOException {
        while (init()) {
            solve();
        }
        System.out.println(ans);
    }
}