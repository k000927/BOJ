import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] depth;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    static void setTree(int cur, int d, int p) {
        depth[cur] = d;
        parent[cur] = p;

        for (int next : tree.get(cur)) {
            if (next == p)
                continue;
            setTree(next, d + 1, cur);
        }
    }

    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];

        while (ah > bh) {
            a = parent[a];
            ah--;
        }

        while (ah < bh) {
            b = parent[b];
            bh--;
        }

        while (true) {
            if (a == b)
                return a;
            a = parent[a];
            b = parent[b];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        depth = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        setTree(1, 1, 0);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ans.append(LCA(a, b)).append("\n");
        }

        System.out.println(ans);
    }
}