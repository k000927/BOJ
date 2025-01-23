import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static long[] num;
    static long[] tree;
    static StringBuilder ans = new StringBuilder();

    static void segTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start];
        } else {
            segTree(node * 2, start, (start + end) / 2);
            segTree(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static void updateSeg(int node, int start, int end, int index, long val) {
        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            num[index] = val;
            tree[node] = val;
            return;
        }

        updateSeg(node * 2, start, (start + end) / 2, index, val);
        updateSeg(node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long getSeg(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0L;
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lSum = getSeg(node * 2, start, (start + end) / 2, left, right);
        long rSum = getSeg(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lSum + rSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        num = new long[n + 1];
        tree = new long[n * 4];

        for (int i = 1; i <= n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }

        segTree(1, 1, n);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) updateSeg(1, 1, n, (int) b, c);
            else ans.append(getSeg(1, 1, n, (int) b, (int) c)).append("\n");
        }

        System.out.println(ans);
    }
}