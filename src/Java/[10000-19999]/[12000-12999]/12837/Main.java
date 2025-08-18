import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static long[] num, tree;

    static void segTree(int node, int left, int right) {
        if (left == right) {
            tree[node] = num[left];
            return;
        }

        segTree(node * 2, left, (left + right) / 2);
        segTree(node * 2 + 1, (left + right) / 2 + 1, right);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void update(int node, int left, int right, int index, int value) {
        if (index < left || right < index) {
            return;
        }

        if (left == right) {
            num[index] += value;
            tree[node] += value;
            return;
        }

        update(node * 2, left, (left + right) / 2, index, value);
        update(node * 2 + 1, (left + right) / 2 + 1, right, index, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long get(int node, int left, int right, int start, int end) {
        if (end < left || right < start) {
            return 0L;
        }

        if (start <= left && right <= end) {
            return tree[node];
        }

        long lValue = get(node * 2, left, (left + right) / 2, start, end);
        long rValue = get(node * 2 + 1, (left + right) / 2 + 1, right, start, end);
        return lValue + rValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        num = new long[N + 1];
        tree = new long[N * 4];
        segTree(1, 1, N);

        StringBuilder sb = new StringBuilder();
        int op, p, q;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            op = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            if (op == 1) {
                update(1, 1, N, p, q);
            } else {
                sb.append(get(1, 1, N, p, q)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
