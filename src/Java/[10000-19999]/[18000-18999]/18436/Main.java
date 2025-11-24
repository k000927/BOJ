import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;
    static int[][] tree;

    static void setTree(int node, int left, int right) {
        if (left == right) {
            tree[A[left] % 2][node] = 1;
        } else {
            setTree(node * 2, left, (left + right) / 2);
            setTree(node * 2 + 1, (left + right) / 2 + 1, right);

            tree[0][node] = tree[0][node * 2] + tree[0][node * 2 + 1];
            tree[1][node] = tree[1][node * 2] + tree[1][node * 2 + 1];
        }
    }

    static int getTree(int treeType, int node, int left, int right, int start, int end) {
        if (left > end || right < start)
            return 0;

        if (start <= left && right <= end)
            return tree[treeType][node];

        int leftNum = getTree(treeType, node * 2, left, (left + right) / 2, start, end);
        int rightNum = getTree(treeType, node * 2 + 1, (left + right) / 2 + 1, right, start, end);

        return leftNum + rightNum;
    }

    static void updateTree(int node, int index, int val, int start, int end) {
        if (index < start || end < index)
            return;

        if (start == end) {
            A[index] = val;
            tree[val % 2][node] = 1;
            tree[(val + 1) % 2][node] = 0;
            return;
        }

        updateTree(node * 2, index, val, start, (start + end) / 2);
        updateTree(node * 2 + 1, index, val, (start + end) / 2 + 1, end);
        tree[0][node] = tree[0][node * 2] + tree[0][node * 2 + 1];
        tree[1][node] = tree[1][node * 2] + tree[1][node * 2 + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tree = new int[2][N * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        setTree(1, 1, N);

        M = Integer.parseInt(br.readLine());
        for (int seq = 0; seq < M; seq++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                updateTree(1, i, x, 1, N);
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                ans.append(getTree(type % 2, 1, 1, N, l, r)).append('\n');
            }
        }

        System.out.print(ans);
    }
}
