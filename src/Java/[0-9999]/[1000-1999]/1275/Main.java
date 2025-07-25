import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;

    static long[] num;
    static long[] tree;

    static void segment(int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start];
        } else {
            segment(node * 2, start, (start + end) / 2);
            segment(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static long get(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        long lsum = get(node * 2, start, (start + end) / 2, left, right);
        long rsum = get(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lsum + rsum;
    }

    static void update(int node, int start, int end, int index, long val) {
        if (index < start || index > end) return;
        if (start == end) {
            num[index] = val;
            tree[node] = val;
            return;
        }

        update(node * 2, start, (start + end) / 2, index, val);
        update(node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        num = new long[N + 1];
        tree = new long[N * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        segment(1, 1, N);

        int x, y, a, b;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int min = Math.min(x, y);
            int max = Math.max(x, y);
            ans.append(get(1, 1, N, min, max)).append('\n');
            update(1, 1, N, a, b);
        }

        System.out.print(ans);
    }
}
