import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static long[] tree;
    static long[] num;
    static final int MOD = 1000000007;

    static void segTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start];
        } else {
            segTree(node * 2, start, (start + end) / 2);
            segTree(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = (tree[node * 2] % MOD * tree[node * 2 + 1] % MOD) % MOD;
        }
    }

    static long getTree(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 1;
        }
        if (left <= start && right >= end) {
            return tree[node];
        }

        long lSum = getTree(node * 2, start, (start + end) / 2, left, right);
        long rSum = getTree(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return (lSum % MOD * rSum % MOD) % MOD;
    }

    static void updateTree(int node, int start, int end, int index, long value) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            num[index] = value;
            tree[node] = value;
            return;
        }
        updateTree(node * 2, start, (start + end) / 2, index, value);
        updateTree(node * 2 + 1, (start + end) / 2 + 1, end, index, value);
        tree[node] = (tree[node * 2] % MOD * tree[node * 2 + 1] % MOD) % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        tree = new long[n * 4];
        num = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }

        segTree(1, 1, n);

        for (int i = 1; i <= m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                updateTree(1, 1, n, b, c);
            } else {
                ans.append(getTree(1, 1, n, b, c)).append("\n");
            }
        }

        System.out.println(ans);
    }
}