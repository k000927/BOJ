import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T, N, ans;
    static int[] parent;
    static Area[] areaList;

    static class Area {
        int x, y, d;

        Area(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) parent[y] = x;
        else parent[x] = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = ans = Integer.parseInt(br.readLine());
            areaList = new Area[N];
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                areaList[i] = new Area(x, y, d);
                parent[i] = i;
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    Area a1 = areaList[i];
                    Area a2 = areaList[j];

                    int dx = a1.x - a2.x;
                    int dy = a1.y - a2.y;

                    if (dx * dx + dy * dy <= (a1.d + a2.d) * (a1.d + a2.d)) {
                        if (find(i) != find(j)) {
                            union(i, j);
                            ans--;
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}