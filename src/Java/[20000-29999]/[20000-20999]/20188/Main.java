import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer>[] tree;
    static int[] subTree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        subTree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            subTree[i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        DFS(1);

        long variety = 0;
        for (int i = 2; i <= N; i++) {
            int restNodeCnt = N - subTree[i];
            variety += nC2(N) - nC2(restNodeCnt);
        }
        System.out.println(variety);
    }

    private static long nC2(int n) {
        return (long) n * (n - 1) / 2;
    }

    private static int DFS(int cur) {

        for (Integer next : tree[cur]) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            subTree[cur] += DFS(next);
        }

        return subTree[cur];
    }
}