import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, A, B;
    static int[] parent;

    static int getDepth(int x) {
        int depth = 0;

        while (parent[x] != 0) {
            x = parent[x];
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        parent = new int[10001];
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i <= N; i++) {
                parent[i] = 0;
            }

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());

                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());

                parent[B] = A;
            }

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int xDepth = getDepth(x);
            int yDepth = getDepth(y);

            while (xDepth != yDepth) {
                if (xDepth > yDepth) {
                    x = parent[x];
                    xDepth--;
                } else {
                    y = parent[y];
                    yDepth--;
                }
            }

            while (x != y) {
                x = parent[x];
                y = parent[y];
            }

            sb.append(x).append('\n');
        }

        System.out.print(sb);
    }
}
