import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] tree;

    static void modify(int node, int left, int right, int index, int value) {
        if (index < left || right < index)
            return;

        if (left == right) {
            tree[node] = value;
            return;
        }

        modify(node * 2, left, (left + right) / 2, index, value);
        modify(node * 2 + 1, (left + right) / 2 + 1, right, index, value);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long sum(int node, int left, int right, int start, int end) {
        if (end < left || right < start) {
            return 0L;
        }

        if (start <= left && right <= end) {
            return tree[node];
        }

        long lQuery = sum(node * 2, left, (left + right) / 2, start, end);
        long rQuery = sum(node * 2 + 1, (left + right) / 2 + 1, right, start, end);

        return lQuery + rQuery;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new long[N * 4];

        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0) {
                sb.append(sum(1, 1, N, Math.min(b, c), Math.max(b, c))).append('\n');
            } else {
                modify(1, 1, N, b, c);
            }
        }

        System.out.print(sb);
    }
}