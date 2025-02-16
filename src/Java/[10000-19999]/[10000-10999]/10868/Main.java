import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] num;
    static int[] tree;

    static void segment(int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start];
        } else {
            segment(node * 2, start, (start + end) / 2);
            segment(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    static int getSegment(int node, int left, int right, int start, int end) {
        if (right < start || left > end) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int leftMin = getSegment(node * 2, left, right, start, (start + end) / 2);
        int rightMin = getSegment(node * 2 + 1, left, right, (start + end) / 2 + 1, end);
        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n + 1];
        tree = new int[n * 4];

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        segment(1, 1, n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(getSegment(1, a, b, 1, n));
        }
    }
}